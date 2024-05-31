package cl.integradoram5.depositar.controller;

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


@WebServlet("/depositar")
public class DepositarFormularioController extends HttpServlet {
	private static final long serialVersionUID = -1309463823570983798L;
	private UsuarioService usuarioService;
	private UsuarioDao usuarioDao;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = new UsuarioDaoImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/depositar/view/formulario-depositar.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String montoFormulario = request.getParameter("monto");
		int monto = Integer.parseInt(montoFormulario);

		if (monto > 0) {
			HttpSession session = request.getSession();
			String nombreUsuario = (String) session.getAttribute("nombreUsuario");
			int saldo = (Integer) session.getAttribute("saldoDisponible");
			int id = (Integer) session.getAttribute("id");
	
			saldo += monto;
			
			Usuario usuario = new Usuario(id, nombreUsuario, saldo);
			usuarioService.editarUsuario(usuario);
			
			session.setAttribute("saldoDisponible", saldo);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home/view/formulario-home.jsp");
		dispatcher.forward(request, resp);
	}
}
