package ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.UserVO;
import service.UserServiceImpl;

@WebServlet("/join.dgccei")
public class JoinServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		System.out.println("Join Ctrl");
		request.setCharacterEncoding("euc-kr"); 
		///////////////////////////////////////////
		String id   = request.getParameter("id");
		String pwd  = request.getParameter("pwd");
		String name = request.getParameter("name");
		UserVO user = new UserVO(id,pwd,name); 
		////////DI
		UserServiceImpl service = new UserServiceImpl();
		int flag = 0;
		try {
			flag = service.join(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag!=0) {
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("fail.html");
			view.forward(request, response);
		}
	}

}












