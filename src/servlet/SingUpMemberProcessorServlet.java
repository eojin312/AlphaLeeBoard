package servlet;
/**
 * 5/20일 회원가입 페이지 서블릿
 */

import servlet.model.AlphaLeeBoardUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SingUpMemberProcessorServlet extends HttpServlet {
    public static final String DB_PWD = "dldjwls02";

    public static final String DB_ID = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/alphaleeboard?useSSL=false";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //캐릭터셋 선언
        req.setCharacterEncoding("utf-8");

        //파라미터 받아오기
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");


        //Connection 과 Statement null 로 초기화
        Connection conn = null;
        PreparedStatement pstmt = null;

        //DB Driver LOAD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //DB 연결
        try {
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
        } catch (SQLException e) {
            PrintWriter out = res.getWriter();
            out.println("디비 접속에 실패했어요..ㅠㅠ 에고");
        }


        //DB 에 넣기
        try {
            // 커넥션을 이용해서 SQL문장(statement)을 만든다
            pstmt = conn.prepareStatement("Insert into alphaleeuser (id, pwd, email) values (?, ?, ?)");

            // ?에 뭐가 들어갈지 결정(set)해준다.
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, email);


            // 문장(statement)을 실행(execute)한다.
            int rows = pstmt.executeUpdate();


            // 잘 들어갔는지 확인하기 위한 select 문장(statement)를 connection을 통해 준비한다(prepare)
            pstmt = conn.prepareStatement("Select alno, id, pwd, email from alphaleeuser where id = ? and email = ?");

            // ?에 뭐가 들어갈지 결정(set)해준다.
            pstmt.setString(1, id);
            pstmt.setString(2, email);

            // 문장을 실행한다. 그러면 ResetSet을 리턴할거다. 그걸 rs라는 변수이름으로 저장한다.
            ResultSet rs = pstmt.executeQuery();

            // ResultSet에서 데이터 가져오기
            if (rs.next()) { // 0행에서 1행으로 커서를 옮기고

                AlphaLeeBoardUser alphaLeeBoardUser = new AlphaLeeBoardUser(rs.getInt("alno"), rs.getString("id"), rs.getString("pwd"), rs.getString("email"));

                // JSP에 전달해주기 위해 setAttribute한다.
                req.setAttribute("alphaLeeBoardUser", alphaLeeBoardUser);

                // 회원가입완료(completed.jsp)페이지로 이동시켜버린다.
                RequestDispatcher view = req.getRequestDispatcher("/alphalee/member/signup/completed.jsp");
                view.forward(req,res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("회원가입에 실패했어요 ㅠㅠ");
            }

        } catch (SQLException | ServletException e) {
            e.printStackTrace();
            //DB 닫기
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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
}