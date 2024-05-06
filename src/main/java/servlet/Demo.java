package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo extends GenericServlet {
public void service(ServletRequest req, ServletResponse res) throws IOException {
	PrintWriter printWriter = res.getWriter();
	printWriter.print("<h1> hiiii </h1>");
	
}
}
