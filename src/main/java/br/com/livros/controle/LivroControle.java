package br.com.livros.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livros.dao.LivroDAO;
import br.com.livros.modelo.Livro;

@WebServlet("/LivroControle")
public class LivroControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivroDAO livroDAO;

	public void init() {
		livroDAO = new LivroDAO();
	}

	public LivroControle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("acao");

		try {
			switch (action) {
			case "listar":
				listarLivro(request, response);
				break;
			case "novo":
				novoLivro(request, response);
				break;
			case "inserir":
				gravarLivro(request, response);
				break;
			case "apagar":
				apagarLivro(request, response);
				break;
			case "editar":
				editarLivro(request, response);
				break;
			case "edicao":
				edicaoLivro(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void novoLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void gravarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
	
		Livro livro = new Livro(nome, autor, categoria);

		livroDAO.inserirLivro(livro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/LivroControle?acao=listar");
		request.setAttribute("mensagem", "livro cadastrado com sucesso");
		dispatcher.forward(request, response);
	}

	private void listarLivro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Livro> listarLivro = livroDAO.listarTodosLivros();

		request.setAttribute("listaLivros", listarLivro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");
		dispatcher.forward(request, response);
		
	}


	private void apagarLivro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Livro livro = new Livro();
		livro.setId(id);
		livroDAO.apagarLivro(livro);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
	}
	
	
	private void editarLivro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
	
		long id = Long.parseLong(request.getParameter("id"));
		
		Livro livro = livroDAO.buscarLivro(id);
		request.setAttribute("livro", livro);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		dispatcher.forward(request, response);
		
	 
	}

	private void edicaoLivro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		
		Livro livro = new Livro(nome, autor, categoria);
		livro.setId(id);
		
		livroDAO.editarLivro(livro);
			
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
		
	}

	
}
