package company_project.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import company_project.dto.Department;
import company_project.service.DepartmentService;

@WebServlet("/DeptListHandler")
public class DeptListHandler extends HttpServlet {
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

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("GET방식");
			List<Department> list = service.selectDepartmentByAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("deptList.jsp").forward(request, response);
		}else {
			System.out.println("POST방식");
			List<Department> list = service.selectDepartmentByAll();	//object>json : toJson
			Gson gson = new Gson();
			String result = gson.toJson(list, new TypeToken<List<Department>>() {}.getType());
			System.out.println("result >> " + result);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			
			PrintWriter pw = response.getWriter();
			pw.print(result);
		}
	}

}
