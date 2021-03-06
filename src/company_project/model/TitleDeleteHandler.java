package company_project.model;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company_project.dto.Title;
import company_project.service.TitleService;

@WebServlet("/TitleDeleteHandler")
public class TitleDeleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TitleService service;

	public void init(ServletConfig config) throws ServletException {
		service = new TitleService();
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
			int titleNo = Integer.parseInt(request.getParameter("titleNo").trim());
			int res = service.removeTitle(new Title(titleNo));
			
			response.getWriter().print(res);
		}else {
			System.out.println("POST방식");
		}
	}

}
