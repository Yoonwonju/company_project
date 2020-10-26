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

import company_project.dto.Title;
import company_project.service.TitleService;

@WebServlet("/TitleListHandler")
public class TitleListHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TitleService service;
       
    public TitleListHandler() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		service = new TitleService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("GET");
			List<Title> list = service.showTitles();
			request.setAttribute("list", list);
			request.getRequestDispatcher("title/titleList.jsp").forward(request, response);
		}else {
			System.out.println("POST");
			List<Title> list = service.showTitles();
			Gson gson = new Gson();
			String result = gson.toJson(list, new TypeToken<List<Title>>() {}.getType());
			System.out.println(result);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			
			PrintWriter pw = response.getWriter();
			pw.print(result);
		}
		
	}

}
