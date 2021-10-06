package model.dao;

import model.vo.UserVO;

import java.sql.*;

public class UserDaoImpl {
    public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static final String dbUser = "scott";
    public static final String dbPwd = "tiger";

    public UserDaoImpl() throws ClassNotFoundException{
      Class.forName(driver);
    }
    public UserVO loginRow(UserVO user) throws SQLException {
        System.out.println("dao loginRow()");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String loginSQL = "select id, pwd, name from tbl_login where id=? and pwd=?";
        UserVO result = null;
        conn = DriverManager.getConnection(url, dbUser, dbPwd);
        System.out.println("conn:" + conn);
        pstmt = conn.prepareStatement(loginSQL);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getPwd());
        rset = pstmt.executeQuery();
        while (rset.next()){
            result = new UserVO(rset.getString(1),rset.getString(2), rset.getString(3));
        }
        conn.close();
        return result;
    }
    public int joinRow(UserVO user) throws SQLException {
        System.out.println("dao joinRow()");
        Connection conn = null;
        PreparedStatement pstmt = null;
        String joinSQL = "insert into tbl_join values(?, ?, ?)";
        int flag = 0;
        conn = DriverManager.getConnection(url, dbUser, dbPwd);
        System.out.println("conn:" + conn);
        pstmt = conn.prepareStatement(joinSQL);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getPwd());
        pstmt.setString(3, user.getName());
        flag = pstmt.executeUpdate();
        conn.close();
        return flag;
    }
}
