package ctrl.factory;

import ctrl.action.Command;
import ctrl.action.LoginAction;

import java.util.HashMap;

/**
 * Singleton pattern
 * 1. 생성자의 접근제어자를 private
 * 2. 자신의 객체를 리턴하는 static 메서드를 정의한다
 * 3. 자신의 객체를 단 한 번만 만들어지도록 구현하는 것이 KeyPoint
 */
public class BeanFactory {
    private static BeanFactory instance;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    private BeanFactory() {
        map.put("/dgccei/login.kpc", new LoginAction());
//        map.put("/dgccei/logout.kpc", new LogoutAction());
//        map.put("/dgccei/join.kpc", new JoinAction());
    }
    public static BeanFactory getInstance(){
        if(instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }
    public Command getBean(String uri){
        return map.get(uri);
    }
}
