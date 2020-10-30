package company_project.service;

import java.util.List;

import company_project.dao.EmployeeDao;
import company_project.dao.Impl.EmployeeDaoImpl;
import company_project.dto.Employee;

public class EmployeeService {
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
	public List<Employee> showEmployees(){
		return empDao.selectEmployeeByAll();
	}
	
	public Employee selectEmployeeByNo(Employee empl) {
		return empDao.selectEmployeeByNo(empl);
	}
	
	public int insertEmployee(Employee empl) {
		return empDao.insertEmployee(empl);
	}

}
