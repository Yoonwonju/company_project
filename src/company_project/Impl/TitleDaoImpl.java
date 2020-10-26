package company_project.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import company_project.dao.TitleDao;
import company_project.ds.JdbcUtilJNDI;
import company_project.dto.Title;

public class TitleDaoImpl implements TitleDao {

	private static final TitleDaoImpl instance = new TitleDaoImpl();
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {
		super();
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				ArrayList<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int titleNo = rs.getInt("TITLE_NO");
		String titleName = rs.getString("TITLE_NAME");
		return new Title(titleNo, titleName);
	}

	@Override
	public int insertTitle(Title title) {
//		String sql = 
		return 0;
	}

	@Override
	public Title selectTitleByNo(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNextNo() {
		String sql = "SELECT MAX(TITLE_NO)+1 FROM TITLE";
		try(Connection con = JdbcUtilJNDI.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
