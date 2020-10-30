package company_project.service;

import java.util.List;

import company_project.dao.TitleDao;
import company_project.dao.Impl.TitleDaoImpl;
import company_project.dto.Title;

public class TitleService {
	private TitleDao titleDao = TitleDaoImpl.getInstance();
	
	public List<Title> showTitles(){
		return titleDao.selectTitleByAll();
	}
	
	public int addTitle(Title title) {
		return titleDao.insertTitle(title);
	}
	
	public Title getTitle(Title title) {
		return titleDao.selectTitleByNo(title);
	}
	
	public int removeTitle(Title title) {
		return titleDao.deleteTitle(title);
	}
	
	public int modifyTitle(Title title) {
		return titleDao.updateTitle(title);
	}
	
	public int getNextNo() {
		return titleDao.getNextNo();
	}
}
