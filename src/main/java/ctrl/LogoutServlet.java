package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.kpc")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("Logout Ctrl");
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("index.jsp"); 
	}

}
