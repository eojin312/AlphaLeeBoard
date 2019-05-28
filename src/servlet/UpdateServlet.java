package servlet;

import servlet.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class UpdateServlet extends HttpServlet {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";
    public static final String DB_ID = "root";
    public static final String DB_PWD = "dldjwls02";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // getParameter 로 article_no 로 넘기기
        String articleNoString = req.getParameter("article_no");
        long articleNo = Long.parseLong(articleNoString);
        // Connection PrepareStatement null 로 초기화
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DB DriverManager 로 경로 연결
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DB 연결
        try {
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Select 로 조회
        try {
            pstmt = conn.prepareStatement("Select article_no, writer, title, contents, create_date, update_date, read_count, recommend_count from article where article_no = ?");
            pstmt.setLong(1, articleNo);
            ResultSet rs = pstmt.executeQuery();
            // ResultSet 으로 커서 내리기
            if (rs.next()) {
                long _articleNo = rs.getLong("article_no");
                String writer = rs.getString("writer");
                String title = rs.getString("title");
                String contents = rs.getString("contents");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                long readCount = rs.getLong("read_count");
                long recommendCount = rs.getLong("recommend_count");
                Article article = new Article(_articleNo, title, writer, contents, createDate, updateDate, readCount, recommendCount);
                req.setAttribute("article", article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // jsp 넘기기
        RequestDispatcher view = req.getRequestDispatcher("/alphalee/board/update/update.jsp");
        view.forward(req, res);


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        // getParameter 로 article_no 로 넘기기
        String articleNoPost = request.getParameter("article_no");

        if (articleNoPost == null || articleNoPost.equals("")) {
            PrintWriter out = response.getWriter();
            out.println("잘못된 요청입니다");
            out.println("<input type=\"button\" onclick=\"history.back()\" value=\"뒤로\">");
            return;
        }

        long articleNo = Long.parseLong(articleNoPost);
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        // Connection PrepareStatement null 로 초기화
        Connection conn = null;
        PreparedStatement pstmt = null;
        // DB DriverManager 로 경로 연결
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DB 연결
        try {
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Update 문으로 업데이트
        try {
            pstmt = conn.prepareStatement("update article set title = ?, contents = ?, update_date = now() where article_no = ? ");
            pstmt.setString(1, title);
            pstmt.setString(2, contents);
            pstmt.setLong(3, articleNo);
            // int rows로 받아주기
            int rows = pstmt.executeUpdate();

            //링크로 이동시키기 (중요)
            response.sendRedirect("/alphalee/board/detail?article_no=" + articleNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // jsp 넘기기
    }

}
