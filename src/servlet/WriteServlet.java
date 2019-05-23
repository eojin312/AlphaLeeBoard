package servlet;

import servlet.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class WriteServlet extends HttpServlet {

    public static final String DB_PWD = "dldjwls02";
    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";
    public static final String FAIL_JSP = "/alphalee/board/write/wt-fail.jsp";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        String writer = req.getParameter("writer");
        String title = req.getParameter("title");
        String contents = req.getParameter("contents");

        Connection conn = null;
        PreparedStatement pstmt = null;

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

        try {
            pstmt = conn.prepareStatement("insert into article (writer, title,  contents, create_date, update_date) values (? ,?, ?, now(), now())", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3,contents);

            int rows = pstmt.executeUpdate();

            if (rows != 1) {
                RequestDispatcher view = req.getRequestDispatcher(FAIL_JSP);
                view.forward(req, res);
            }

            ResultSet rs4Key = pstmt.getGeneratedKeys();
            long lastInsertedArticleNo = 0;
            if (rs4Key.next()) {
                lastInsertedArticleNo = rs4Key.getLong(1);
            } else {
                RequestDispatcher view = req.getRequestDispatcher(FAIL_JSP);
                view.forward(req, res);
            }

            pstmt = conn.prepareStatement("select article_no, writer, title, contents, create_date from article where article_no = ?");
            pstmt.setLong(1, lastInsertedArticleNo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
//                WriterModel writerModel = new WriterModel(rs.getInt("wtno"), rs.getString("name"), rs.getString("writing"));
                long _articleNo = rs.getLong("article_no");
                String _writer = rs.getString("writer");
                String _title = rs.getString("title");
                String _contents = rs.getString("contents");
                String _createDate = rs.getString("create_date");

                Article article = new Article(_articleNo, _writer, _title, _contents, _createDate);
                req.setAttribute("article", article);
                RequestDispatcher view = req.getRequestDispatcher("/alphalee/board/write/wt-complete.jsp");
                view.forward(req, res);
            } else {
                RequestDispatcher view = req.getRequestDispatcher(FAIL_JSP);
                view.forward(req, res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
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
