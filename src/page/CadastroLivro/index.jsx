import React from 'react';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import axios from 'axios';
import { toast } from 'react-toastify';
import './style.css';

const schemaLivro = yup.object({
  titulo: yup.string().required('O título é obrigatório.').min(2, 'Mínimo 2 caracteres.'),
  autor: yup.string().required('O autor é obrigatório.'),
  isbn: yup.string().required('O ISBN é obrigatório.').matches(/^[\d-]+$/, 'Apenas números e traços.').min(10, 'Mínimo 10 dígitos.'),
  quantidadeEstoque: yup.number().typeError('Deve ser um número.').min(0, 'Não pode ser negativo.').integer('Deve ser inteiro.').required('Obrigatório.')
}).required();

export default function CadastroLivro() {
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    resolver: yupResolver(schemaLivro)
  });

  const onSubmit = async (data) => {
    try {
      const tokenBasico = btoa("admin@biblioteca.com:123"); 

      await axios.post('http://localhost:8080/api/livros', data, {
        headers: {
          'Authorization': `Basic ${tokenBasico}`
        }
      });

      toast.success('Livro cadastrado com sucesso!');
      reset(); 
    } catch (error) {
      toast.error('Erro ao cadastrar o livro.');
      console.error(error);
    }
  };

  return (
    <div className="cadastro-container">
      <h2>Cadastrar Novo Livro</h2>
      <form onSubmit={handleSubmit(onSubmit)}>
        
        <div className="input-group">
          <label>Título:</label>
          <input type="text" {...register("titulo")} />
          {errors.titulo && <span className="erro">{errors.titulo.message}</span>}
        </div>

        <div className="input-group">
          <label>Autor:</label>
          <input type="text" {...register("autor")} />
          {errors.autor && <span className="erro">{errors.autor.message}</span>}
        </div>

        <div className="input-group">
          <label>ISBN:</label>
          <input type="text" {...register("isbn")} />
          {errors.isbn && <span className="erro">{errors.isbn.message}</span>}
        </div>

        <div className="input-group">
          <label>Quantidade em Estoque:</label>
          <input type="number" {...register("quantidadeEstoque")} />
          {errors.quantidadeEstoque && <span className="erro">{errors.quantidadeEstoque.message}</span>}
        </div>

        <button type="submit">Salvar Livro</button>
      </form>
    </div>
  );
}