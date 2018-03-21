package com.getallnames;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class GetAllNames extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//2.Get the db connection
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=74123";
			con = DriverManager.getConnection(dbUrl);

			//3. Issue the SQL query via connection
			String query = "SELECT * FROM person_info";

			//4. Process the results
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			out.println("<table border=1 width=50%><tr><th>RegNo.</th><th>First Name</th><th>Last Name</th></tr>");
			
			while(rs.next())
			{
				int regno=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				out.println("<tr><td><h5>"+regno+"</h5></td><td><h5>"+fname+"</h5></td><td><h5>"+lname+"</h5></td><tr>");
			}	
			out.println("</table>");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		//5. Closing all the JDBC Objects
		finally
		{
			try{
				if(stmt != null)
				{
					stmt.close();
				}
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
