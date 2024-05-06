package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.A3BankDao;
import dto.A3BankUserData;
@WebServlet("/signuppp")
public class A3BankControll extends HttpServlet
{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = req.getParameter("Name");
		String Email = req.getParameter("Email"); 
		
		String mob = req.getParameter("Mob");
		long Mob = Long.parseLong(mob);
		
		String dob = req.getParameter("Dob");
		Date Dob = Date.valueOf(dob);
		Period period = Period.between(Dob.toLocalDate(), LocalDate.now());
		int age = period.getYears();
		
		String Gender = req.getParameter("Gender");
		String Password = req.getParameter("Password");
		
		A3BankUserData a3BankUserData = new A3BankUserData();
	
		A3BankDao a3BankDao = new A3BankDao();
		
		if (age>=8) {
			if (a3BankDao.check1(Email).isEmpty() && a3BankDao.check2(Mob).isEmpty()) {
				a3BankUserData.setUserName(Name);
				a3BankUserData.setEmail(Email);
				a3BankUserData.setMobNo(Mob);
				a3BankUserData.setDob(Dob);
				a3BankUserData.setGender(Gender);
				a3BankUserData.setPass(Password);
				a3BankDao.save(a3BankUserData); 
				res.getWriter().print("<h1>Welcome "+Name+"</h1><p>Your Account has been created</p>\n <a href="+"UserLogin.jsp"+"> <button>Login</button> </a>" );
				req.getRequestDispatcher("commonresponse.jsp").include(req, res);
			} else { 
				req.getSession().setAttribute("errormsg", "Email Id or Mobile number already exists");
				req.getRequestDispatcher("register.jsp").forward(req, res);
			}
		} else {
			req.getSession().setAttribute("errormsg", "You are under age.");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
			 
		}
		
		
	}


