package demotest;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class DeleteCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Cookie[] ck = req.getCookies();
		
		PrintWriter out =  resp.getWriter();
		if(ck != null)
		{
			for(Cookie c:ck)
			{
				c.setMaxAge(0);
				resp.addCookie(c);
			}
			out.print("<h1>Cookies are deleted</h1>");
		}else
		{
			out.println("<h1>No Cookies are found</h1>");
		}
	}
}
