package servlet;

import servlet.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet {

    public static final String DB_PWD = "dldjwls02";
    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // 캐릭터셋선언
        req.setCharacterEncoding("UTF-8");


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
            pstmt = conn.prepareStatement("Select article_no, title, writer, create_date, update_date, read_count, recommend_count  from article order by article_no desc limit 0, 10");
            ResultSet rs = pstmt.executeQuery();
            List<Article> articleList = new ArrayList<Article>();
            while (rs.next()) {
                long articleNo = rs.getLong("article_no");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String createDate = rs.getString("create_date");
                String updatdDate = rs.getString("update_date");
                long readCount = rs.getLong("read_count");
                long recommendCount = rs.getLong("recommend_count");
                Article article = new Article(articleNo, title, writer, createDate, updatdDate, readCount, recommendCount);
                articleList.add(article);
            }
            req.setAttribute("articleList", articleList);
            RequestDispatcher view = req.getRequestDispatcher("/alphalee/board/list/list.jsp");
            view.forward(req, res);
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
