import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class empDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<empDTO> listemp(){
		ArrayList<empDTO> list = new ArrayList<empDTO>();
		try {
			connDB();
			String query= "select a.employee_id,a.emp_name,b.emp_name manager_name,c.department_name "
							;
			
			this.stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(query);
			while(rs.next()) {
				int employee_id=rs.getInt("employee_id"); //불러오는것
				String emp_name=rs.getString("emp_name");
				int manager_id=rs.getInt("manager_id");
				int department_id=rs.getInt("department_id");
				empDTO mvo=new empDTO();
				mvo.setEmployee_id(employee_id); //저장하기
				mvo.setEmp_name(emp_name);
				mvo.setManager_id(manager_id);
				mvo.setDepartment_id(department_id);
				list.add(mvo);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();	
		} return list;
	}private void connDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "ora_user";
		String passcode ="human123";
	
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, userid, passcode);
			stmt = conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
}
