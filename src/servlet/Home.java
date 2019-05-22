package servlet;

import servlet.model.Inquire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Home extends HttpServlet {

    public static final String DB_PWD = "dldjwls02";
    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // 캐릭터셋선언
        req.setCharacterEncoding("UTF-8");
        // 파라미터 받아오기
        String title = req.getParameter("title");
        String createDate = req.getParameter("create_date");

        // Connetion Prepare~ null 로 초기화
        Connection conn = null;
        PreparedStatement pstmt = null;
        // Driver 연결
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DB 연결
        try {
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // DB 쿼리 넣기
        try {
            pstmt = conn.prepareStatement("Select article_no, title, create_date from article order by article_no desc");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                long _articleNo = rs.getLong("article_no");
                String _title = rs.getString("title");
                String _createDate = rs.getString("create_date");
                Inquire inquire = new Inquire(_articleNo, _title, _createDate);
                req.setAttribute("inquire", inquire);
                // JSP 연결
                RequestDispatcher view = req.getRequestDispatcher("/alphalee/index.jsp");
                view.forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // DB 연결
        finally {
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
