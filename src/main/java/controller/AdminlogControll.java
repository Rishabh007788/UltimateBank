package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.A3BankDao;
import dao.BankAccountdao;
import dto.A3BankUserData;
import dto.BankAccountdto;
@WebServlet("/adminlogin")
public class AdminlogControll extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String email =req.getParameter("email");
	String pass = req.getParameter("password");
     BankAccountdao accountdao = new BankAccountdao();
     A3BankDao a3BankDao = new A3BankDao();
	if (pass.equals("admin@123") && email.equals("admin@gmail.com")) {
		List<BankAccountdto> list = accountdao.fetchall();
		List<BankAccountdto> savingaccounts = accountdao.fetchSavingAcc();
		List<A3BankUserData> userlist = a3BankDao.fetchall();
		List<BankAccountdto> currentaccounts = accountdao.fetchCurrentAcc();
		
		req.getSession().setAttribute("savingaccounts", savingaccounts); 
		req.getSession().setAttribute("currentaccounts", currentaccounts); 
		req.getSession().setAttribute("userlist", userlist); 
		req.getSession().setAttribute("list", list); 
		req.getRequestDispatcher("Adminhome.jsp").forward(req, res);
	} else {
			System.out.println("invalid password"); 
	}
}
}
