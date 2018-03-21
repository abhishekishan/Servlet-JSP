package com.insertpersoninfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class JDBCImpl
{
	public boolean createProfile(Person p)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//2.Get the db connection
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db?user=root&password=74123";
			con = DriverManager.getConnection(dbUrl);

			//3. Issue the SQL query via connection
			String query1 = "INSERT INTO person_info values(?,?,?)";
			pstmt=con.prepareStatement(query1);
			pstmt.setInt(1, p.getRegNo());
			pstmt.setString(2, p.getfName());
			pstmt.setString(3, p.getlName());

			int count1=pstmt.executeUpdate();

			String query2 = "INSERT INTO person_otherinfo values(?,?,?)";
			pstmt=con.prepareStatement(query2);
			pstmt.setInt(1, p.getRegNo());
			pstmt.setString(2, p.getPass());
			pstmt.setString(3, p.getIsAdmin());

			int count2=pstmt.executeUpdate();

			//4. Process the results
			if(count1>0 && count2>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally {
			//5. Closing all the JDBC Objects
			try{
				if(pstmt != null)
				{
					pstmt.close();
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
		return false;
	}
}

