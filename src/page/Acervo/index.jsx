import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './style.css';

export default function Acervo() {
  const [livros, setLivros] = useState([]);

  useEffect(() => {
    // Busca a lista de livros na API (Rota pública ou com Basic Auth)
    axios.get('http://localhost:8080/api/livros')
      .then(response => setLivros(response.data))
      .catch(error => console.error("Erro ao buscar livros:", error));
  }, []);

  return (
    <div className="acervo-container">
      <h2>Acervo da Biblioteca</h2>
      <table className="tabela">
        <thead>
          <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>ISBN</th>
            <th>Estoque</th>
          </tr>
        </thead>
        <tbody>
          {livros.map(livro => (
            <tr key={livro.id}>
              <td>{livro.titulo}</td>
              <td>{livro.autor}</td>
              <td>{livro.isbn}</td>
              <td>{livro.quantidadeEstoque}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}