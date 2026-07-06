import React from 'react';
import { Link } from 'react-router-dom';
import './style.css';

export default function Home() {
  return (
    <div className="home-container">
      <h2>Bem-vindo ao LêAi</h2>
      <p>Gerencie o acervo, alunos e empréstimos de forma rápida e fácil.</p>
      
      <div className="dashboard-cards">
        <Link to="/acervo" className="card">Consultar Acervo</Link>
        <Link to="/novo-emprestimo" className="card">Registrar Empréstimo</Link>
        <Link to="/emprestimos" className="card">Ver Empréstimos Ativos</Link>
      </div>
    </div>
  );
}