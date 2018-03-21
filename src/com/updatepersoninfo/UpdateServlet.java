package com.updatepersoninfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insertpersoninfo.JDBCImpl;

public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int regno=Integer.parseInt(req.getParameter("reg_No"));
		String old_pass=req.getParameter("oldpass");
		String new_pass=req.getParameter("newpass");
		
		PersonDetails p=new PersonDetails();
		p.setRegNo(regno);
		p.setOldPass(old_pass);
		p.setNewPass(new_pass);
		
		JDBCImplements jdimp=new JDBCImplements();
		boolean res=jdimp.updatePassword(p);
		{
			if(res)
				out.println("Password Changed Sucessfully");
			else
				out.println("Failed to change the password");
		}
	}
}
