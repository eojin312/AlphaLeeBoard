package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlphaLeeBoadServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //실행 시에 한글깨짐 방지
        req.setCharacterEncoding("UTF-8");
        //setAttribute를 통해 메시지 입력
        req.setAttribute("message", "안녕하세요 알파리 게시판입니다.");
        req.setAttribute("version", "V1.0");
        //jsp 연결
        RequestDispatcher view = req.getRequestDispatcher("/board/index.jsp");
        view.forward(req, res);
    }

}
