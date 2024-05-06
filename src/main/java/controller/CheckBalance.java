package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankAccountdao;
import dto.BankAccountdto;

@WebServlet("/checkBalance")
public class CheckBalance extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int acno = Integer.parseInt(req.getParameter("accno"));
	int pin =Integer.parseInt(req.getParameter("pin"));
	BankAccountdao accountdao = new BankAccountdao();
	BankAccountdto account= accountdao.fetchone(acno);
	if (account.getPin()==pin) {
		req.getSession().setAttribute("accdetails", account); 
		req.getRequestDispatcher("balancemsg.jsp").forward(req, resp);
	} else {
		req.getSession().setAttribute("checkbalerrormsg", "incorrect pin"); 
		req.getRequestDispatcher("CustomerHome.jsp").forward(req, resp);
	}
	
}
}
