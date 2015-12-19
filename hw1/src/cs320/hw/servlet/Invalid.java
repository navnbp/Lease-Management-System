package cs320.hw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hw/Invalid")
public class Invalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Invalid() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		 request.getRequestDispatcher( "/WEB-INF/hw/Invalid.jsp" ).forward(request, response );
		
		
	}

}
