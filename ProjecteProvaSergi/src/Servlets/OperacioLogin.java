package Servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EstructuraDeDades.Jugador;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/OperacioLogin")
public class OperacioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setAttribute("Clau", "Valor");
//		
		
		Jugador Sergi = new Jugador("Sergi", 1700, "La Selva");
		Jugador Oscar = new Jugador("Oscar", 2900, "Barcelona UGA");
		Jugador Coguen = new Jugador("Coguen", 1000000, "Cerap");
		List<Jugador> ordreForces = Arrays.asList(Sergi, Oscar, Coguen);
		request.setAttribute("PlayerList", ordreForces);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LlistaJugadors.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
