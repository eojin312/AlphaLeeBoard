package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateRecommendCountServlet extends HttpServlet {

    public static final String DB_PWD = "dldjwls02";

    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // getParameter로 article_no 받기
        String articleNoString = req.getParameter("article_no");
        long articleNo = Long.parseLong(articleNoString);
        // DB 연결
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
        } catch (SQLException e) {
            PrintWriter out = res.getWriter();
            out.println("DB연결에 실패했습니다. 관라자에게 문의바랍니다.");
            return;
        }
        // Update 문 작성
        // sql 문장 작성
        try {
            pstmt = conn.prepareStatement("update article set recommend_count = recommend_count + 1 where article_no = ?");
            pstmt.setLong(1, articleNo);

            // Update 문 실행
            int rows = pstmt.executeUpdate();

            // jsp 글 상세로 이동
            res.sendRedirect("/alphalee/board/detail?article_no=" + articleNo);

        } catch (SQLException e) {
            PrintWriter out = res.getWriter();
            out.println(e.getMessage());
            return;
        }
    }
}
