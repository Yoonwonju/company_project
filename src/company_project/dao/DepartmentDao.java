package company_project.dao;

import java.util.List;

import company_project.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	Department selectDepartmentByNo(Department dept);

	int insertDepartment(Department dept);
	
	int updateDepartment(Department dept);
	
	int deleteDepartment(Department dept);
	
	int getNextNo();
}
