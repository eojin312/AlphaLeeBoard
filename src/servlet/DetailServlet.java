package servlet;

import servlet.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 게시글 상세
 * /alphalee/board/detail
 */
public class DetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String articleNoString = req.getParameter("article_no");
        if (articleNoString == null) {
            // 에러 JSP페이지로 이동
        }
        long articleNo = Long.parseLong(articleNoString);

        // 게시글 한개를 조회
        // select ~~~ where aricle_no = ?

        // 조회수 올리기
        // update set read_count = read_count +1 where article_no = ?

        Article article = new Article();

        req.setAttribute("articleNo" , articleNo);

        // JSP로 이동
        RequestDispatcher view = req.getRequestDispatcher("/alphalee/board/detail/detail.jsp");
        view.forward(req, res);
    }
}
