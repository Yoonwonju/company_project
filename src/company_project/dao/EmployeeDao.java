package company_project.dao;

import java.util.List;

import company_project.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();

	Employee selectEmployeeByNo(Employee empl);
	
	int insertEmployee(Employee empl);

	int idDupCheck(int empNo);
}
