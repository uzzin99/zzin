

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empServlet
 */
@WebServlet("/emp")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //출력에 한글이 깨지지 않게
		PrintWriter out = response.getWriter();
		empDAO dao = new empDAO();
		ArrayList<empDTO> list=dao.listemp();
		
		out.print("<html><head><title>Result from employees</title></head><body>");
		out.print("<table border =1><tr><th>employee_id</th><th>emp_name</th><th>manager_id</th><th>department_id</th>"); //head line
		for(int i=0;i<list.size();i++) {
			empDTO mvo = list.get(i);
			int employee_id = mvo.getEmployee_id();
			String emp_name = mvo.getEmp_name();
			int manager_id = mvo.getManager_id();
			int department_id = mvo.getDepartment_id();
			
			out.print("<tr><td>"+employee_id+"</td><td>"+emp_name+"</td><td>"+manager_id+"</td><td>"+department_id+"</td>>");
		}
		out.print("</table></body></html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
