package cl.praxis.controllers;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.models.Conexion;
import cl.praxis.models.LoginModel;

@WebServlet("/SvController")
public class SvController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nick = request.getParameter("nick");
		String calle = request.getParameter("calle");
		String numero = request.getParameter("numero");
		Integer peso = Integer.parseInt(request.getParameter("peso"));
		String rol = request.getParameter("rol");
		
		LoginModel login = new LoginModel();
		login.setName(nombre);
		login.setEmail(email);
		login.setPassword(password);
		login.setNick(nick);
		login.setAdress(calle + numero);
		login.setWeight(peso);
		login.setRol(rol);
		request.setAttribute("modelo", login);
		
		
		String sql = "insert into usuarios(correo, nick, nombre, password, peso) values (email, nick, nombre, password, peso)";
		
		try {
			Connection c = Conexion.getCon();
			Statement s = (Statement) c.createStatement();
			int resultado = ((java.sql.Statement) s).executeUpdate(sql);
			System.out.println(resultado);
			
			} catch (Exception e) {
			System.out.println("Error al obtener cliente " +
			e);
			}
		
		if(rol.equals("administrativo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/home.html");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
		rd.forward(request, response);

	}

}
