import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// Importação dos Componentes
import Header from './components/Header';
import Footer from './components/Footer';

// Importação das Páginas
import Home from './page/Home';
import Acervo from './page/Acervo';
import CadastroLivro from './page/CadastroLivro';
import CadastroAluno from './page/CadastroAluno';
import NovoEmprestimo from './page/NovoEmprestimo';
import EmprestimosAtivos from './page/EmprestimosAtivos';

function App() {
  return (
    <BrowserRouter>
      {/* O Header aparece em todas as páginas */}
      <Header /> 
      
      <main className="container-principal">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/acervo" element={<Acervo />} />
          <Route path="/cadastrar-livro" element={<CadastroLivro />} />
          <Route path="/cadastrar-aluno" element={<CadastroAluno />} />
          <Route path="/novo-emprestimo" element={<NovoEmprestimo />} />
          <Route path="/emprestimos" element={<EmprestimosAtivos />} />
        </Routes>
      </main>

      {/* O Footer aparece em todas as páginas */}
      <Footer />

      {/* Container global para os alertas de erro/sucesso */}
      <ToastContainer position="top-right" autoClose={3000} />
    </BrowserRouter>
  );
}

export default App;