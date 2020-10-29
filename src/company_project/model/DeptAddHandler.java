package company_project.model;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import company_project.dto.Department;
import company_project.service.DepartmentService;

@WebServlet("/DeptAddHandler")
public class DeptAddHandler extends HttpServlet {
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
		if(request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("GET방식");
			int nextNo = service.getNextNo();
			System.out.println("nextNo --> " + nextNo);
			
			response.getWriter().print(nextNo);;	// ajax > 여기 > ajax
		}else {
			System.out.println("POST방식");
			Gson gson = new Gson();
			Department newDept = gson.fromJson(new InputStreamReader(request.getInputStream(), "UTF-8"), Department.class); // json>Object : fromJson
			System.out.println(newDept);
			
			int res = service.addDept(newDept);
			
			response.getWriter().print(res);
		}
	}

}
