package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrl.action.Command;
import ctrl.factory.BeanFactory;
import ctrl.view.ModelAndView;

@WebServlet("*.kpc")
public class FrontServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("client uri : "+uri); 
		BeanFactory factory = BeanFactory.getInstance();
		Command ctrl = factory.getBean(uri);
		ModelAndView mv=null;
		try {
			mv = ctrl.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(mv.isSend()) {
			RequestDispatcher view = request.getRequestDispatcher(mv.getPage());
			view.forward(request, response);
		}else {
			response.sendRedirect(mv.getPage()); 
		}
	}
}











