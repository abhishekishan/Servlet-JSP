package com.insertpersoninfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		int regno=Integer.parseInt(req.getParameter("reg_No"));
		String fname=req.getParameter("f_name");
		String lname=req.getParameter("l_name");
		String pass=req.getParameter("password");
		String user=req.getParameter("user");

		Person p=new Person();
		p.setRegNo(regno);
		p.setfName(fname);
		p.setlName(lname);
		p.setPass(pass);
		p.setIsAdmin(user);

		JDBCImpl jdimp=new JDBCImpl();
		boolean res=jdimp.createProfile(p);
		{
			if(res)
				out.println("Data Inserted Sucessfully");
			else
				out.println("Failed to insert the data");
		}
	}
}
