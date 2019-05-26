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

/**
 * 게시글 상세
 * /alphalee/board/detail
 */
public class DetailServlet extends HttpServlet {

    public static final String DB_PWD = "dldjwls02";
    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String articleNoString = req.getParameter("article_no");
        if (articleNoString == null) {
            // 에러 JSP페이지로 이동
        }
        long articleNo = Long.parseLong(articleNoString);

        // Connect PrepareStatement null 로 초기화
        Connection conn = null;
        PreparedStatement pstmt = null;

        // DB Driver LOAD
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


        // 게시글 한개를 조회
        // select ~~~ where aricle_no = ?
        try {
            pstmt = conn.prepareStatement("Select article_no, writer, title, contents, create_date, update_date, read_count, recommend_count from article where article_no = ? ");
            pstmt.setLong(1, articleNo);
            ResultSet rs = pstmt.executeQuery();

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

                // 조회수 올리기
                // update set read_count = read_count +1 where article_no = ?
                pstmt = conn.prepareStatement("UPDATE article set read_count = read_count + 1 where article_no = ?");
                pstmt.setLong(1, articleNo);

                int rows = pstmt.executeUpdate();

                // JSP로 이동
                RequestDispatcher view = req.getRequestDispatcher("/alphalee/board/detail/detail.jsp");
                view.forward(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("해당 게시글이 존재하지 않습니다");
                out.println("<inqut type=\"button\" onclick=\"history.back()\" value=\"뒤로가기\">");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
