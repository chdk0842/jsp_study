package ch08.quiz1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistController
 */
@WebServlet("/rontrol")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RegistService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		service = new RegistService();	
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		// action parameter의 값을 얻어온다.
		String view = "";
		
		//처음엔 action값이 null이라서 getServletContext().getRequestDispatcher("/rcontrol?action=list") 실행
		if (action == null) {
			getServletContext().getRequestDispatcher("/rontrol?action=list")
			.forward(request, response);
		//요청한 것을 다시 뷰로 보냄
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "info":
				view = info(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/quiz1/" + view)
			.forward(request, response);
		}
		
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		// 한가지 상품만 가져온다.
		Regist r = service.find(request.getParameter("id"));
		request.setAttribute("r", r);
		return "registInfo.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		// 모든 상품을 가져온다.
		List<Regist> rlist = service.findAll();
		request.setAttribute("regist", rlist);
		return "registList.jsp";
	}
       
   
}
