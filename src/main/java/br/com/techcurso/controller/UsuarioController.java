package br.com.techcurso.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techcurso.entidade.Usuario;
import br.com.techcurso.persistencia.jdbc.UsuarioDao;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	
	
	private String id;
	//Construtor... é chamado antes do INIT
	public UsuarioController() {
		System.out.println("Novo servidor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("INIT...");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu = new Usuario();
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		if (acao == null || acao.equals("")) {
			req.setAttribute("listaUsu", usuDao.buscaportodos());
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispatcher.forward(req, resp);
		}
		if (acao.equals("deletar")) {

			if (id != null) {
				usu.setId(Integer.parseInt(id));
			}
			usuDao.deletar(usu);
			resp.sendRedirect("usucontroller.do");
		}
		if ((acao.equals("editar")) && !(id == null || id.equals(""))) {
						
			usu = usuDao.buscaporid(Integer.parseInt(id));
			req.setAttribute("usuario", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/editausu.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usu = new Usuario();
		
		usu.setNome(req.getParameter("nome"));
		usu.setLogin(req.getParameter("login"));
		usu.setSenha(req.getParameter("senha"));
		UsuarioDao usuDao = new UsuarioDao();
		String id = req.getParameter("id");

		if(!id.equals("")) {
			usu.setId(Integer.parseInt(id));
		}
		
		usuDao.salvar(usu);
		resp.sendRedirect("usucontroller.do");
		
		}
	

}
