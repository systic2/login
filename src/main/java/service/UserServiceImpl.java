package service;

import model.dao.UserDaoImpl;
import model.vo.UserVO;

import java.sql.SQLException;

public class UserServiceImpl {
    public UserServiceImpl() {
    }
    public UserVO login(UserVO user) throws ClassNotFoundException, SQLException {
        System.out.println("service login");
        UserDaoImpl dao = new UserDaoImpl();
        return dao.loginRow(user);
    }
    public int join(UserVO user) throws ClassNotFoundException, SQLException {
        System.out.println("service join");
        UserDaoImpl dao = new UserDaoImpl();
        return dao.joinRow(user);
    }
}
