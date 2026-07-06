import React from 'react';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import axios from 'axios';
import { toast } from 'react-toastify';
import './style.css';

const schemaAluno = yup.object({
  nome: yup.string().required('O nome é obrigatório').min(3, 'Mínimo de 3 letras'),
  matricula: yup.string().required('A matrícula é obrigatória'),
  turma: yup.string().required('A turma é obrigatória')
}).required();

export default function CadastroAluno() {
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    resolver: yupResolver(schemaAluno)
  });

  const onSubmit = async (data) => {
    try {
      const tokenBasico = btoa("admin@biblioteca.com:123");

      await axios.post('http://localhost:8080/api/alunos', data, {
        headers: {
          'Authorization': `Basic ${tokenBasico}`
        }
      });

      toast.success('Aluno cadastrado com sucesso!');
      reset(); 
    } catch (error) {
      toast.error('Erro ao cadastrar o aluno.');
      console.error(error);
    }
  };

  return (
    <div className="cadastro-container">
      <h2>Cadastrar Novo Aluno</h2>
      <form onSubmit={handleSubmit(onSubmit)}>
        
        <div className="input-group">
          <label>Nome Completo:</label>
          <input type="text" {...register("nome")} />
          {errors.nome && <span className="erro">{errors.nome.message}</span>}
        </div>

        <div className="input-group">
          <label>Matrícula:</label>
          <input type="text" {...register("matricula")} />
          {errors.matricula && <span className="erro">{errors.matricula.message}</span>}
        </div>

        <div className="input-group">
          <label>Turma:</label>
          <input type="text" {...register("turma")} />
          {errors.turma && <span className="erro">{errors.turma.message}</span>}
        </div>

        <button type="submit">Salvar Aluno</button>
      </form>
    </div>
  );
}