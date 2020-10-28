package company_project.model;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company_project.dto.Department;
import company_project.service.DepartmentService;

@WebServlet("/DeptDeleteHandler")
public class DeptDeleteHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DepartmentService service;
	
	public void init(ServletConfig config) throws ServletException {
		service = new DepartmentService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("GET방식");
			int deptNo = Integer.parseInt(request.getParameter("deptNo").trim());
			int res = service.removeDepartment(new Department(deptNo));
			System.out.println("9999");
			response.getWriter().print(res); // goto dept.jsp의 ajax
		} else {
			System.out.println("POST방식");
		}

	}

}