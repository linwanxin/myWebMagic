package Dao;

import Entity.BaozouNews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author:林万新 lwx
 * Date:  2017/11/10
 * Time: 9:45
 */
public class BaozouDao {
    private static Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/baozou";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e){
            System.err.println("class not found");
        }catch (SQLException e){
            System.err.println("sql异常1");
        }
        return  conn;
    }

    public static int insert(BaozouNews news){
        int i = 0;
        Connection connection = getConn();
        //注意主键自增
        String sql = "insert into baozou(author,time,content) values(?,?,?)";
        PreparedStatement pstmt;
        try{
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setString(1,news.getAuthor());
            pstmt.setString(2,news.getTime());
            pstmt.setString(3,news.getContent());
             i  = pstmt.executeUpdate();
             pstmt.close();
             connection.close();

        }catch (SQLException e){
            System.err.println("sql 异常2");
        }
        return i;
    }

}
