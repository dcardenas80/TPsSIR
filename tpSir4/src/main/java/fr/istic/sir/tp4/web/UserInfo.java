package fr.istic.sir.tp4.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.sir.tp4.datamodel.Person;
import fr.istic.sir.tp4.jpa.dao.PersonDAO;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Person person = new Person();
		person.setLastName(request.getParameter("name"));
		person.setName(request.getParameter("firstname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		person.setEmail(request.getParameter("email"));
		PersonDAO personDAO = new PersonDAO();
		personDAO.create(person);
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "\n"
				+ " <LI>Email: " + request.getParameter("email") + "\n" +"</UL>\n" + "</BODY></HTML>");
	}
}
