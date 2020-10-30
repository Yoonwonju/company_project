package company_project.model;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company_project.dto.Employee;
import company_project.service.EmployeeService;

@WebServlet("/EmpGetHandler")
public class EmpGetHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeService service;

	public void init(ServletConfig config) throws ServletException {
		service = new EmployeeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("GET방식");
			int empNo = Integer.parseInt(request.getParameter("empNo").trim());
			Employee emp = service.selectEmployeeByNo(new Employee(empNo));
			System.out.println("emp --> " + emp);
			
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("emp.jsp").forward(request, response);
		}else {
			System.out.println("POST방식");
		}
	}

}