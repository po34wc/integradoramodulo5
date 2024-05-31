package cl.integradoram5.login.controller;

import java.io.IOException;

import cl.integradoram5.usuario.model.dao.UsuarioDao;
import cl.integradoram5.usuario.model.dao.impl.UsuarioDaoImpl;
import cl.integradoram5.usuario.model.entidad.Usuario;
import cl.integradoram5.usuario.model.service.UsuarioService;
import cl.integradoram5.usuario.model.service.impl.UsuarioServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login-formulario")
public class LoginFormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	private UsuarioDao usuarioDao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = new UsuarioDaoImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuarioFormulario = req.getParameter("usuario");
		Usuario usuario = new Usuario(usuarioFormulario);
		Usuario resultado = usuarioService.crearUsuario(usuario);
		String urlDispatcher = "formulario-home.jsp";

		HttpSession session = req.getSession();
		session.setAttribute("nombreUsuario", resultado.getNombre());
		session.setAttribute("saldoDisponible", resultado.getSaldoDisponible());
		session.setAttribute("id", resultado.getId());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/home/view/" + urlDispatcher);
		dispatcher.forward(req, resp);
	}
}
