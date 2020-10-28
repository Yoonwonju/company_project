package company_project.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import company_project.dao.DepartmentDao;
import company_project.ds.JdbcUtilJNDI;
import company_project.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();
	
	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	private DepartmentDaoImpl() {
		super();
	}

	@Override
	public List<Department> selectDepartmentByAll() {
		String sql = "SELECT DEPT_NO,DEPT_NAME,FLOOR FROM DEPARTMENT";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				ArrayList<Department> list = new ArrayList<Department>();
				do {
					list.add(getDepartment(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}

	//DB에 있는 DEPT_NO, DEPT_NAME, FLOOR을 deptNo, deptName, floor에 저장하여 Department객체 생성
	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("DEPT_NO");
		String deptName = rs.getString("DEPT_NAME");
		int floor = rs.getInt("FLOOR");
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public Department selectDepartmentByNo(Department dept) {
		String sql = "SELECT DEPT_NO,DEPT_NAME,FLOOR FROM DEPARTMENT WHERE DEPT_NO=?";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptNo());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public int insertDepartment(Department dept) {
		String sql = "INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,FLOOR) VALUES (?, ?, ?)";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int updateDepartment(Department dept) {
		String sql = "UPDATE DEPARTMENT SET DEPT_NAME = ?, FLOOR = ? WHERE DEPT_NO = ?";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getFloor());
			pstmt.setInt(3, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int deleteDepartment(Department dept) {
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_NO = ?";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int getNextNo() {
		String sql = "SELECT MAX(DEPT_NO)+1 FROM DEPARTMENT";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return 0;
	}

}
