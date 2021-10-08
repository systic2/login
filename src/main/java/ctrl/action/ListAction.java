package ctrl.action;

import ctrl.view.ModelAndView;
import model.vo.BoardVO;
import service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class ListAction implements Command{
    private UserServiceImpl service;
    public ListAction(){
        service = new UserServiceImpl();
    }
    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ListAction execute");
        ArrayList<BoardVO> lists = service.list();
        request.setAttribute("lists", lists);
        ModelAndView view = new ModelAndView();
        view.setPage("list.jsp");
        view.setSend(true);
        return view;
    }
}
