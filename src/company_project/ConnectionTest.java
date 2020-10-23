package company_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) {

	}

	private static void connection_test02() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false";  
		String user = "company_project";
		String pwd = "rootroot";

		try(Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT DEPT_NO,DEPT_NAME,FLOOR FROM DEPARTMENT");){
			while(rs.next()) {
				int deptNo = rs.getInt("dept_no");
				String deptName = rs.getString("dept_name");
				int floor = rs.getInt("floor");
				System.out.printf("%d %s %d%n", deptNo, deptName, floor);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
}
