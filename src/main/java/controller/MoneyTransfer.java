package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.A3BankDao;
import dao.BankAccountdao;
import dto.BankAccountdto;
import dto.BankTransaction;

@WebServlet("/money_trans")
public class MoneyTransfer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int rec_accno=Integer.parseInt(req.getParameter("rec_accno"));
		int sen_accno=Integer.parseInt(req.getParameter("sen_accno"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		double ammount = Double.parseDouble(req.getParameter("amount"));
		
		BankAccountdao bankAccountdao = new BankAccountdao();
		BankAccountdto sen_accountd = bankAccountdao.fetchone(sen_accno);
		BankAccountdto rec_account = bankAccountdao.fetchone(rec_accno);
		BankTransaction sen_transaction = new BankTransaction();
		BankTransaction rec_transaction = new BankTransaction();
		
		if (sen_accountd.getPin()==pin) {
			if (rec_account!=null && rec_account.isStatus()&&rec_account.getA3BankUserData().getUserName().equals(name)) {
				if (sen_accountd.getAmount()>=ammount) {
					sen_accountd.setAmount(sen_accountd.getAmount()-ammount);
					rec_account.setAmount(rec_account.getAmount()+ammount);
					//set the trasaction details
					sen_transaction.setBalance(sen_accountd.getAmount());
					sen_transaction.setDateTime(LocalDateTime.now());
					sen_transaction.setDeposite(0);
					sen_transaction.setWithdraw(ammount);
					sen_transaction.setMethod("sent to "+rec_accno);
					
					rec_transaction.setBalance(rec_account.getAmount());
					rec_transaction.setDateTime(LocalDateTime.now());
					rec_transaction.setDeposite(ammount);
					rec_transaction.setWithdraw(0);
					rec_transaction.setMethod("from "+sen_accno);
					
					List<BankTransaction> sentrancList=sen_accountd.getList();
					List<BankTransaction> rectrancList = rec_account.getList();
					
					sentrancList.add(sen_transaction);
					rectrancList.add(rec_transaction);
					
					rec_account.setList(rectrancList);
					sen_accountd.setList(sentrancList);
					
					bankAccountdao.update(sen_accountd);
					bankAccountdao.update(rec_account);
					resp.getWriter().printf("<h1>"+ ammount+" successfully transferred to "+rec_accno + "</h1> <h1>Thank you for using Ultimate Bank</h1>");
					req.getRequestDispatcher("commonresponse.jsp").include(req, resp);
					
				} else {
					// Insufficient amount........
					req.getSession().setAttribute("transaction_errormsg", "Insufficient balance");
					req.getRequestDispatcher("CustomerHome.jsp").forward(req, resp);
				}
			} else {
				// receiver's data not found........
				req.getSession().setAttribute("transaction_errormsg", "receiver's data not found");
				req.getRequestDispatcher("CustomerHome.jsp").forward(req, resp);
			}
		} else {
					// wrong pin.......
			req.getSession().setAttribute("transaction_errormsg", "wrong pin");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, resp);
		}
		
		
	}
}
