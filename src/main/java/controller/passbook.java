package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import dao.BankAccountdao;
import dto.BankAccountdto;
import dto.BankTransaction;
@WebServlet("/feth_passbook")
public class passbook extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int acno = Integer.parseInt(req.getParameter("accno"));
		int pin =Integer.parseInt(req.getParameter("pin"));
		BankAccountdao accountdao = new BankAccountdao();
		BankAccountdto account= accountdao.fetchone(acno);
		List<BankTransaction> transactions = account.getList();
		if (account.getPin()==pin) {
			req.getSession().setAttribute("transactions", transactions); 
			req.getRequestDispatcher("commonresponse.jsp").forward(req, res);
		} else {
			req.getSession().setAttribute("passbookerrormsg", "incorrect pin"); 
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
	} 
		
		
	
}
