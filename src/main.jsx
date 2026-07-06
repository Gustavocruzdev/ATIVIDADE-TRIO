import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';

// Importação do CSS global
import './index.css'; 

// Renderiza o aplicativo React dentro da div com id="root" do index.html
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);