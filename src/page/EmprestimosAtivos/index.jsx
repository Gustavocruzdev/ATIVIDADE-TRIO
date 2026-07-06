import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './style.css';

export default function EmprestimosAtivos() {
  const [emprestimos, setEmprestimos] = useState([]);

  useEffect(() => {
    const tokenBasico = btoa("admin@biblioteca.com:123");
    
    axios.get('http://localhost:8080/api/emprestimos', {
      headers: { 'Authorization': `Basic ${tokenBasico}` }
    })
      .then(response => setEmprestimos(response.data))
      .catch(error => console.error("Erro ao buscar empréstimos:", error));
  }, []);

  return (
    <div className="acervo-container">
      <h2>Empréstimos Ativos</h2>
      <table className="tabela">
        <thead>
          <tr>
            <th>ID Aluno</th>
            <th>ID Livro</th>
            <th>Data Devolução</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {emprestimos.map(emp => (
            <tr key={emp.id}>
              <td>{emp.alunoId}</td>
              <td>{emp.livroId}</td>
              <td>{emp.dataDevolucao}</td>
              <td>Ativo</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}