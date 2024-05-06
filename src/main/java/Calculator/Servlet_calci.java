package Calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_calci implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = req.getParameter("num1");
		int x = Integer.parseInt(a);
		
		String b = req.getParameter("num2");
		int y = Integer.parseInt(b);
		String ope = req.getParameter("btn");
		PrintWriter o = res.getWriter();
		
		switch(ope) {
		case "+": System.out.println(x+y);
		o.print(x+y);
		break;
		
		case "-": System.out.println(x-y);
		o.print(x-y);
		break;
		
		case "*": System.out.println(x*y);
		o.print(x*y);
		break;
		
		case "/": System.out.println(x/y);
		o.print(x/y);
		break;
		
		}
		
	}

}
