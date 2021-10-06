package ctrl.action;

import ctrl.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
