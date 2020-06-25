package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *
 * @Author hustffx
 * @Date 2020/6/11 23:24
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///springdb", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("select * from account");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
