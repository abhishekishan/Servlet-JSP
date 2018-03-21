package com.updatepersoninfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class JDBCImplements
{
	public boolean updatePassword(PersonDetails p)
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
			String query = "UPDATE  person_otherinfo SET password=? where regno=? AND password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, p.getNewPass());
			pstmt.setInt(2, p.getRegNo());
			pstmt.setString(3, p.getOldPass());

			int count=pstmt.executeUpdate();

			//4. Process the results
			if(count>0)
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
