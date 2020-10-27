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

import company_project.dto.Title;
import company_project.service.TitleService;

@WebServlet("/TitleAddHandler")
public class TitleAddHandler extends HttpServlet {
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
			int nextNo = service.getNextNo();
			System.out.println("nextNo --> " + nextNo);
			
			response.getWriter().print(nextNo);
		}else {
			System.out.println("POST방식");
			Gson gson = new Gson();
			Title newTitle = gson.fromJson(new InputStreamReader(request.getInputStream(), "UTF-8"), Title.class);
			System.out.println(newTitle);
			
			int res = service.addTitle(newTitle);
			response.getWriter().print(res);
		}
	}

}
