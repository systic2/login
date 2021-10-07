package ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.UserVO;
import service.UserServiceImpl;


@WebServlet("/login.kpc")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("LoginServlet doGet"); 
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		UserVO user = new UserVO();
		user.setId(id); 	user.setPwd(pwd); 
		
		UserServiceImpl service = new UserServiceImpl();
		UserVO result = null;
		try {
			result = service.login(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginSession", result); 
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("fail.html");
			view.forward(request, response);
		}
		
	}

}



