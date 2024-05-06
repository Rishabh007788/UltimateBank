package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.A3BankDao;
import dto.A3BankUserData;
@WebServlet("/loginncon") 
public class A3BankLoginControll extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		A3BankDao a3BankDao = new A3BankDao();
		
		if (!a3BankDao.check1(email).isEmpty()) {
			A3BankUserData a3BankUserData = a3BankDao.check1(email).get(0);
			String password = a3BankUserData.getPass();
				if (password.equals(pass)) {
					req.getSession().setAttribute("A3BankUserData", a3BankUserData);
				
				req.getRequestDispatcher("CustomerHome.jsp").include(req, res);
				} else { 
					req.setAttribute("errorMessage", "wrong password");
		            // Forward the request to the login page
		            req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
				}
				
		}
		else {
			req.setAttribute("error", "User not found");
            // Forward the request to the login page
            req.getRequestDispatcher("UserLogin.jsp").forward(req, res);
		//	req.getRequestDispatcher("SignUp.html").include(req, res);
		}
		
		
		
	}
}

