package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcServlet
 */
@WebServlet("/calc")
public class calcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    request : 클라이언트가 요청한(보낸) 내용들이 담겨있다.
		  int n1 = Integer.parseInt(request.getParameter("n1"));
	      int n2 = Integer.parseInt(request.getParameter("n2"));
	      System.out.println("n1 : " + n1 + "\nn2 : " + n2);
	      
	      String op = request.getParameter("op");
	      System.out.println("op : " + op);
	      
	      long result = 0;   // 연산의 결과를 담을 변수
	      
	      switch(op) {
	      case "+" : result = n1 + n2;
	      break;
	      case "-" : result = n1 - n2;
	      break;
	      case "*" : result = n1 * n2;
	      break;
	      case "/" : result = n1 / n2;
	      break;
	      }
	      
	      response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	      out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
	      .append("계산결과 : " + result + "<body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
