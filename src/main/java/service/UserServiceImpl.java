package service;

import model.dao.UserDaoImpl;
import model.vo.BoardVO;
import model.vo.UserVO;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<BoardVO> list() throws ClassNotFoundException {
        System.out.println("service list");
        UserDaoImpl dao = new UserDaoImpl();
        return dao.listRow();
    }
}
