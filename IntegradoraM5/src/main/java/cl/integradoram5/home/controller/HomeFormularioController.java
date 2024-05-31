package cl.integradoram5.home.controller;

import java.io.IOException;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeFormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		int saldo = (Integer) session.getAttribute("saldoDisponible");
		String saldoDisponible = Integer.toString(saldo);
		String html;
		html="""
				<html>
				<head>
					<meta charset="UTF-8">
					<title>Home</title>
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
				</head>			
				<body>
					<div class="container">
						<div class="row">
							<div class="cold-md-12">
								<div class="mb-3">
									<h1>Nombre: __nombreUsuario__</h1>
									<p>SaldoDisponible: $__saldoDisponible__</P>
								</div>
								<div class="mb-3">
									<a href="/persona/view/formulario-persona.jsp">
										<button type="button" class="btn btn-primary btn-lg">Depositar</button>
									</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="/retirar">
										<button type="button" class="btn btn-secondary btn-lg">Retirar</button>
									</a>
								</div>
							</div>
						</div>
					</div>				
				</body>						
				</html>
			""".replace("__nombreUsuario__", nombreUsuario)
			   .replace("__saldoDisponible__", saldoDisponible);

		response.getWriter().print(html);
//		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String usuarioFormulario = req.getParameter("usuario");
//		Usuario usuario = new Usuario(usuarioFormulario);
//		boolean resultado = usuarioService.crearUsuario(usuario);
//		String urlDispatcher = "home-formulario.jsp";
//
//		HttpSession session = req.getSession();
//		session.setAttribute("nombreUsuario", usuario.getNombre());
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/home/view/" + urlDispatcher);
//		dispatcher.forward(req, resp);
		doGet(request, response);
	}
}
