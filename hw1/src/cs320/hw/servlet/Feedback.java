package cs320.hw.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.Apartment;
import cs320.hw.entity.LeaseDetails;


@WebServlet("/hw/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Feedback() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Apartment> apLst= new ArrayList<Apartment>();
		try {
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call get_apartment_details()}");
			DatabaseConnection.cstmt.execute();
			DatabaseConnection.rs=DatabaseConnection.cstmt.getResultSet();

			while (DatabaseConnection.rs.next()) {
				Apartment ap= new Apartment();
				ap.setId(DatabaseConnection.rs.getInt("id"));
				ap.setApartmentId(DatabaseConnection.rs.getString("apartment_id"));
				ap.setApartmentType(DatabaseConnection.getApartmentType(DatabaseConnection.rs.getInt("apartment_type_id")));
				ap.setFacility(DatabaseConnection.rs.getString("facility"));
				ap.setMaximumPeople(DatabaseConnection.rs.getInt("max_ppl"));
				ap.setRent(DatabaseConnection.rs.getBigDecimal("rent"));
				ap.setDeposit(DatabaseConnection.rs.getBigDecimal("deposit"));
				ap.setVacant(DatabaseConnection.rs.getBoolean("vacant"));
				ap.setIsRentedOut(DatabaseConnection.rs.getBoolean("is_rented_out"));
				
				apLst.add(ap);
				
			
			}
		} catch (Exception e) 
		{
			request.getSession().setAttribute("errorFeedback", "Something went wrong...!! Try again..");
			System.out.println("Lease Details : "+e.getMessage());
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}

		request.setAttribute("apLst", apLst);
		 request.getRequestDispatcher("/WEB-INF/hw/Feedback.jsp" ).forward(request, response );
//		response.sendRedirect("Feedback.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LeaseDetails> leaseDetailsLst= new ArrayList<LeaseDetails>();
		leaseDetailsLst=(ArrayList<LeaseDetails>)request.getServletContext().getAttribute("leaseDetailsLst" );
	 int appointmentid=Integer.parseInt(request.getSession().getAttribute("appointmentid").toString());
	int aptId=Integer.parseInt(request.getSession().getAttribute("aptId").toString());
	Boolean error=Boolean.FALSE;
	request.getSession().setAttribute("errorFeedback", "");
	String page="/WEB-INF/hw/Feedback.jsp";
	
	
	if(leaseDetailsLst==null)
		leaseDetailsLst=new ArrayList<LeaseDetails>();
	
	try{
		
	 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
	   sdf.parse(request.getParameter("date").toString());
	  }
	catch(Exception e)
	{
		request.getSession().setAttribute("errorFeedback", "Enter the date in mm:dd:yyyy hh:mm:ss format");	
		error=Boolean.TRUE;
		response.reset();
		doGet(request, response);
		return;	
			
	}
	
	
	if(!error)
	{
		try
		{
		 
			DatabaseConnection.conn=DatabaseConnection.getConnection();
			DatabaseConnection.cstmt=DatabaseConnection.conn.prepareCall("{call insert_lease_details(?,?,?,?,?,?,?)}");
			DatabaseConnection.cstmt.setInt(1,Integer.parseInt(request.getSession().getAttribute("appointmentid").toString()));
			DatabaseConnection.cstmt.setString(2, request.getParameter("name"));
			DatabaseConnection.cstmt.setString(3,request.getParameter("date"));
			DatabaseConnection.cstmt.setString(4,request.getParameter("docs"));
			DatabaseConnection.cstmt.setBigDecimal(5, new BigDecimal(request.getParameter("rent").toString()));
			DatabaseConnection.cstmt.setBigDecimal(6,  new BigDecimal(request.getParameter("deposit").toString()));
			DatabaseConnection.cstmt.setString(7,request.getParameter("comments"));
			DatabaseConnection.cstmt.executeUpdate();
			request.getSession().setAttribute("errorFeedback", "");
		}
		catch(Exception e)
		{
			System.out.println("Feedback : "+e.getMessage());
			request.getSession().setAttribute("errorFeedback", "Something went wrong...!! Try again..");	
			error=Boolean.TRUE;
			response.reset();
			doGet(request, response);
			return;	
			
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}
	}
	request.getSession().setAttribute("appointmentid",appointmentid );
	request.getSession().setAttribute("aptId",aptId );
	
	 if(error==Boolean.TRUE)
		 request.getRequestDispatcher(page).forward(request, response );
	 else
		 
		 response.sendRedirect("DisplayFeedback");
		
		
	}

}
