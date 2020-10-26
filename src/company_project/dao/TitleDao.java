package company_project.dao;

import java.util.List;

import company_project.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	
	int insertTitle(Title title);
	
	Title selectTitleByNo(Title title);
	
	int deleteTitle(Title title);
	
	int updateTitle(Title title);
	
	int getNextNo();

}
