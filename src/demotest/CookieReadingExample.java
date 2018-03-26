package demotest;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookies")
public class CookieReadingExample extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Cookie[] c = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		if(c == null)
		{
			out.println("Cookies are not Present in the Browser");
		}
		else
		{
			out.println("Cookies are present");
			for(Cookie ck:c)
			{
				out.println("<h1>Name: "+ck.getName()+"</h1>");
				out.println("<h1>Value: "+ck.getValue()+"</h1>");
				out.println("<br>");
			}
		}
		resp.setContentType("text/html");
	}
}
