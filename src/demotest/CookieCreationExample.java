package demotest;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createCookie")
public class CookieCreationExample extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		Cookie c1 = new Cookie("name1","Abhishek");
		Cookie c2 = new Cookie("name2", "Raj");
		c2.setMaxAge(3600);
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		PrintWriter out = resp.getWriter();
		out.println("Cookie are sent to the Browser");
	}
}