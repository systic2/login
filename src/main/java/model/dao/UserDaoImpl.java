package model.dao;

import model.vo.BoardVO;
import model.vo.UserVO;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl {
    public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String dbUser = "scott";
    public static final String dbPwd = "tiger";

    public UserDaoImpl() throws ClassNotFoundException{
      Class.forName(driver);
    }
    public UserVO loginRow(UserVO user) {
        System.out.println("dao loginRow()");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String loginSQL = "select id, pwd, name from tbl_login where id=? and pwd=?";
        UserVO result = null;
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPwd);
            System.out.println("conn:" + conn);
            pstmt = conn.prepareStatement(loginSQL);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPwd());
            rset = pstmt.executeQuery();
            while (rset.next()){
                result = new UserVO(rset.getString(1),rset.getString(2), rset.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    public int joinRow(UserVO user) {
        System.out.println("dao joinRow()");
        Connection conn = null;
        PreparedStatement pstmt = null;
        String joinSQL = "insert into tbl_login values(?, ?, ?)";
        int flag = 0;
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPwd);
            System.out.println("conn:" + conn);
            pstmt = conn.prepareStatement(joinSQL);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getName());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public ArrayList<BoardVO> listRow() {
        System.out.println("dao listRow()");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String listSQL = "select seq, title, writer, content, regdate, cnt from bbs";
        ArrayList<BoardVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPwd);
            pstmt = conn.prepareStatement(listSQL);
            rset = pstmt.executeQuery();
            while (rset.next()){
                BoardVO board = new BoardVO(rset.getInt(1),
                        rset.getString(2), rset.getString(3),
                        rset.getString(4), rset.getString(5),
                        rset.getInt(6));
                list.add(board);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
