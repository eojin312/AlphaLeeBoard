package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        // GetParameter 로 id pwd  가지고오기
        // Connection PrepareStatement null 로 초기화
        // DB 연결
        // select * from alphaleeuser where id= ?;
        // if(ResultSet.next()) 를 통해서 커서 내림
        // if 문을 통해서 저장된 정보와 일치하면 정보가 출력되는 jsp 로 넘김
        // pstmt 와 conn 닫기
    }
}

