package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/llogoutt")
public class Logoutt extends HttpServlet {

@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	if (session!=null) {
		session.invalidate();
	}
	req.getRequestDispatcher("welcome.jsp").forward(req, res);
	}

}
