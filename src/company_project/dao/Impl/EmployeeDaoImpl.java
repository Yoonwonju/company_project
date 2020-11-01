package company_project.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import company_project.dao.EmployeeDao;
import company_project.ds.JdbcUtilJNDI;
import company_project.dto.Department;
import company_project.dto.Employee;
import company_project.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	
	public static EmployeeDaoImpl getInstance() {
		return instance;
	}

	private EmployeeDaoImpl() {
		super();
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "SELECT EMP_NO , EMP_NAME , TNO , MANAGER , SALARY , DNO , EMAIL , TEL , REGDATE , PIC_URI,\r\n"
				+ "	   TITLE_NAME , DEPT_NAME , MANAGER_NAME\r\n"
				+ "  FROM VM_EMPLOYEE_JOIN";
			try(Connection con = JdbcUtilJNDI.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					ArrayList<Employee> list = new ArrayList<Employee>();
					do {
						list.add(getEmployee(rs));
					}while(rs.next());
					return list;
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("EMP_NO");
		String empName = rs.getString("EMP_NAME");
		Title title = new Title(rs.getInt("TNO"), rs.getString("TITLE_NAME"));
		Employee manager = new Employee(rs.getInt("MANAGER"));
		int salary = rs.getInt("SALARY");
		Department dept = new Department(rs.getInt("DNO"));
		String email = rs.getString("EMAIL");
//		String passwd = rs.getString("PASSWD");
		String passwd = null;
		Date regDate = rs.getDate("REGDATE");
		String tel = rs.getString("TEL");
		String picUri = rs.getString("PIC_URI");
		
		try {
			passwd = rs.getString("PASSWD");
		}catch(SQLException e) {
		}
		try {
			String titleName = rs.getString("TITLE_NAME");
			title.setTitleName(titleName);
		}catch(SQLException e) {
		}
		try {
			String deptName = rs.getString("DEPT_NAME");
			dept.setDeptName(deptName);
		}catch(SQLException e) {
		}
		try {
			String managerName = rs.getString("MANAGER_NAME");
			manager.setEmpName(managerName);
		}catch(SQLException e) {
		}
		
		Employee emp = new Employee(empNo, empName, title, manager, salary, dept, email, regDate, tel, picUri);
		if(passwd != null) {
			emp.setPasswd(passwd);
		}
		return emp;
	}

	@Override
	public Employee selectEmployeeByNo(Employee empl) {
		String sql = "SELECT EMP_NO , EMP_NAME , TNO , MANAGER , SALARY , DNO , EMAIL , TEL , REGDATE , PIC_URI,\r\n"
				+ "	   TITLE_NAME , DEPT_NAME , MANAGER_NAME\r\n"
				+ "  FROM VM_EMPLOYEE_JOIN\r\n"
				+ " WHERE EMP_NO = ?";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, empl.getEmpNo());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee empl) {
		String sql ="INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD, TEL)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, empl.getEmpNo());
			pstmt.setString(2, empl.getEmpName());
			pstmt.setInt(3, empl.getTitle().getTitleNo());
			pstmt.setInt(4, empl.getManager().getEmpNo());
			pstmt.setInt(5, empl.getSalary());
			pstmt.setInt(6, empl.getDept().getDeptNo());
			pstmt.setString(7, empl.getEmail());
			pstmt.setString(8, empl.getPasswd());
			pstmt.setString(9, empl.getTel());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int idDupCheck(int empNo) {
		String sql = "SELECT EMP_NO FROM EMPLOYEE WHERE EMP_NO = ?";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, empNo);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return 0;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return 1;
	}
}
