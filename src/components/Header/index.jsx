import React from 'react';
import { Link } from 'react-router-dom';
import './style.css';

export default function Header() {
  return (
    <header className="header-container">
      <div className="logo">
        <h1>LêAi</h1>
      </div>
      <nav className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/acervo">Acervo</Link>
        <Link to="/cadastrar-livro">Novo Livro</Link>
        <Link to="/cadastrar-aluno">Novo Aluno</Link>
        <Link to="/novo-emprestimo">Emprestar</Link>
        <Link to="/emprestimos">Devoluções</Link>
      </nav>
    </header>
  );
}