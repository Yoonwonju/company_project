package company_project.service;

import java.util.List;

import company_project.dao.EmployeeDao;
import company_project.dao.Impl.EmployeeDaoImpl;
import company_project.dto.Department;
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

	public int duplicateEmpNo(int empNo) {
		return empDao.idDupCheck(empNo);
	}

	public List<Employee> getManagerListByDno(Department dept) {
		return empDao.selectMangerListByDno(dept);
	}

	public int modifyEmployee(Employee empl) {
		return empDao.updateEmployee(empl);
	}
	
	public int removeEmployee(Employee empl) {
		return empDao.deleteEmployee(empl);
	}

}
