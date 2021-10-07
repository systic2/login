package model.dao;

import model.vo.UserVO;

import java.sql.*;

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
}
