package br.com.techcurso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.techcurso.entidade.Usuario;
import br.com.techcurso.persistencia.jdbc.UsuarioDao;

@WebServlet("/autenticar.do")
public class AutenticarController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usu = new Usuario();

		usu.setLogin(req.getParameter("login"));
		usu.setSenha(req.getParameter("senha"));
		UsuarioDao usuDao = new UsuarioDao();

		if (usuDao.autenticar(usu) != null) {
			usu = usuDao.autenticar(usu);
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usu);
			session.setMaxInactiveInterval(60 * 5);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		} else {
			resp.getWriter()
					.print("<script> window.alert('Usuário não encontrado'); location.href='login.html'</script>");
		}

	}

}
