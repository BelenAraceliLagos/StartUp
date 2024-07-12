package cl.praxis.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.models.Conexion;


@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SvLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		try {
			
			Connection c = Conexion.getCon();
			
			Statement s = c.createStatement();
			
			String sql = "Select correo from usuarios";
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.equals(email)) {
					System.out.println("usuario encontrado");
				}
				else {
					System.out.println("Usuario no existe!");
				}
			}
		}catch(SQLException e) {
			System.out.println("Error buscando usuario");
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
