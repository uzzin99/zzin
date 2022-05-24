

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class modifyServlet
 */
@WebServlet("/modify")
public class modifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
	      String id=request.getParameter("id"); // no update because of primary key
	      String pwd=request.getParameter("password");
	      String name=request.getParameter("name");
	      String mobile=request.getParameter("mobile");
	      String joindate=request.getParameter("joindate");
	      MemberVO mvo=new MemberVO();
	      mvo.setId(id);
	      mvo.setPwd(pwd);
	      mvo.setName(name);
	      mvo.setMobile(mobile);
	      mvo.setJoinDate(joindate);
	      MemberDAO dao=new MemberDAO();
	      dao.updateMember(mvo);
	      response.sendRedirect("member");
	}

}
