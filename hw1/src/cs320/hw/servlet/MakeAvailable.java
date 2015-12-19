package cs320.hw.servlet;

import cs320.hw.dal.DatabaseConnection;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hw/makeAvailable")
public class MakeAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeAvailable() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		DatabaseConnection.conn=DatabaseConnection.getConnection();
		DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call make_available(?)}");
		DatabaseConnection.cstmt.setInt(1,Integer.parseInt(request.getParameter("aptid")));
		DatabaseConnection.cstmt.executeUpdate();
		
		}catch(Exception e)
		{
			System.out.println("make available : "+e.getMessage());
			
		}finally
		{
			DatabaseConnection.closeConnection();
		}
		response.sendRedirect("ViewApartment");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
