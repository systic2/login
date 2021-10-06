package ctrl.action;

import ctrl.view.ModelAndView;
import model.vo.UserVO;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction implements Command{
    private UserServiceImpl service;
    public LoginAction(){
        service = new UserServiceImpl();
    }

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LoginAction execute");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        UserVO user = new UserVO();
        user.setId(id);
        user.setPwd(pwd);
        UserVO result = service.login(user);
        ModelAndView view = new ModelAndView();
        if(result != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginSession", result);
            view.setPage("index.jsp");
            view.setSend(true);
        }else{
            view.setPage("fail.html");
            view.setSend(false);
        }
        return null;
    }
}
