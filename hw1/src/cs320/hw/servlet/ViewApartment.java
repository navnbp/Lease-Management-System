package cs320.hw.servlet;

import cs320.hw.dal.DatabaseConnection;
import cs320.hw.entity.Apartment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hw/ViewApartment")
public class ViewApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
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
			System.out.println("View Apartment :"+e.getMessage());
		}
		finally
		{
			DatabaseConnection.closeConnection();
		}

		request.setAttribute("apLst", apLst);
		request.getRequestDispatcher( "/WEB-INF/hw/ViewApartment.jsp" ).forward(request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
