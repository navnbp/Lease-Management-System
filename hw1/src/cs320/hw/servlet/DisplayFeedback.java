package cs320.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.LeaseDetails;

@WebServlet("/hw/DisplayFeedback")
public class DisplayFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<LeaseDetails> leaseDetails= new ArrayList<LeaseDetails>();
		try
		{
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_lease_details()}");
			DatabaseConnection.cstmt.execute();
			DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();
			while (DatabaseConnection.rs.next()) {
				LeaseDetails ld= new LeaseDetails();
				ld.setLeaseId(DatabaseConnection.rs.getInt("lease_id"));
				ld.setAptId(DatabaseConnection.rs.getString("apartment_id"));
				ld.setLeaseHoldername(DatabaseConnection.rs.getString("lease_holder_name"));
				ld.setLeaseTerminationDate(DatabaseConnection.rs.getString("lease_termination_date"));
				ld.setDocs(DatabaseConnection.rs.getString("docs"));
				ld.setRent(DatabaseConnection.rs.getBigDecimal("rent"));
				ld.setDeposit(DatabaseConnection.rs.getBigDecimal("deposit"));
				ld.setComments(DatabaseConnection.rs.getString("comments"));
				leaseDetails.add(ld);
				
				request.getSession().setAttribute("errorDisplayFeedback", "");
				
		}
		}catch(Exception e)
		{
			System.out.println("Display Feedback :"+e.getMessage());
			request.getSession().setAttribute("errorDisplayFeedback", "Some thing went Wrong...!! Try again.. ");	
		}finally
		{
			DatabaseConnection.closeConnection();
		}
		
		
		request.setAttribute("leaseDetails",leaseDetails);
		request.getRequestDispatcher("/WEB-INF/hw/DisplayFeedback.jsp" ).forward(request, response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
