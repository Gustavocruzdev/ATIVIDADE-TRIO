import React from 'react';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import axios from 'axios';
import { toast } from 'react-toastify';
import './style.css';

const schemaEmprestimo = yup.object({
  alunoId: yup.string().required('O ID ou Matrícula do aluno é obrigatório.'),
  livroId: yup.string().required('O ID ou ISBN do livro é obrigatório.'),
  dataDevolucao: yup.date().typeError('Insira uma data válida.').min(new Date(), 'A data não pode ser no passado.').required('Obrigatório.')
}).required();

export default function NovoEmprestimo() {
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    resolver: yupResolver(schemaEmprestimo)
  });

  const onSubmit = async (data) => {
    try {
      const tokenBasico = btoa("admin@biblioteca.com:123");

      await axios.post('http://localhost:8080/api/emprestimos', data, {
        headers: {
          'Authorization': `Basic ${tokenBasico}`
        }
      });

      toast.success('Empréstimo registrado com sucesso!');
      reset();
    } catch (error) {
      toast.error('Erro ao registrar empréstimo.');
      console.error(error);
    }
  };

  return (
    <div className="cadastro-container">
      <h2>Registrar Empréstimo</h2>
      <form onSubmit={handleSubmit(onSubmit)}>
        
        <div className="input-group">
          <label>ID do Aluno:</label>
          <input type="text" {...register("alunoId")} />
          {errors.alunoId && <span className="erro">{errors.alunoId.message}</span>}
        </div>

        <div className="input-group">
          <label>ID do Livro:</label>
          <input type="text" {...register("livroId")} />
          {errors.livroId && <span className="erro">{errors.livroId.message}</span>}
        </div>

        <div className="input-group">
          <label>Data de Devolução Prevista:</label>
          <input type="date" {...register("dataDevolucao")} />
          {errors.dataDevolucao && <span className="erro">{errors.dataDevolucao.message}</span>}
        </div>

        <button type="submit">Registrar Empréstimo</button>
      </form>
    </div>
  );
}