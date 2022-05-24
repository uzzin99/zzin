

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class preupdateServlet
 */
@WebServlet("/update")
public class preupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public preupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	      String id=request.getParameter("id");
	      MemberDAO dao=new MemberDAO();
	      MemberVO mvo=dao.getMember(id);
	      
	      PrintWriter out=response.getWriter();
	      String outstr="<!DOCTYPE html>";
	      outstr+="<html><head><meta charset='UTF-8'><title>Update t_member</title></head>";
	      outstr+="<body align=center><form method=POST action=modify id=frmUpdate>";
	      outstr+="<table align=center border=1>";
	      outstr+="<tr><td>ID</td><td><input type=text name=id value='"+id+"' readonly></td></tr>";
	      outstr+="<tr><td>비밀번호</td><td><input type=text name=password value='"+mvo.getPwd()+"'></td></tr>";
	      outstr+="<tr><td>이름</td><td><input type=text name=name value='"+mvo.getName()+"'></td></tr>";
	      outstr+="<tr><td>모바일</td><td><input type=text name=mobile value='"+mvo.getMobile()+"'></td></tr>";
	      outstr+="<tr><td>등록일</td><td><input type=date name=joindate value='"+mvo.getJoindate()+"'></td></tr>";
	      outstr+="<tr><td colspan=2 align=center><input type=submit value='수정완료'><input type=reset value='비우기'></td></tr>";
	      outstr+="</table></form></body></html>";
	      out.print(outstr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
