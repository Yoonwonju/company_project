package company_project.service;

import java.util.List;

import company_project.Impl.DepartmentDaoImpl;
import company_project.dao.DepartmentDao;
import company_project.dto.Department;

public class DepartmentService {
	private DepartmentDao deptDao = DepartmentDaoImpl.getInstance();
	
	public List<Department> selectDepartmentByAll(){
		return deptDao.selectDepartmentByAll();
	}
	
	public Department getDepartment(Department dept) {
		return deptDao.selectDepartmentByNo(dept);
	}

	public int addDepartment(Department dept) {
		return deptDao.insertDepartment(dept);
	}
	
	public int modifyDepartment(Department dept) {
		return deptDao.updateDepartment(dept);
	}
	
	public int removeDepartment(Department dept) {
		return deptDao.deleteDepartment(dept);
	}
	
	public int getNextNo() {
		return deptDao.getNextNo();
	}
}
