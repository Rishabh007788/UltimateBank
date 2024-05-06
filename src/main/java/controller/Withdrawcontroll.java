package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankAccountdao;
import dto.BankAccountdto;
import dto.BankTransaction;

@WebServlet("/withdraw")
public class Withdrawcontroll extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long accno = Long.parseLong(req.getParameter("acno"));
		double amount = Double.parseDouble(req.getParameter("amount"));

		BankAccountdto bankAccountdto2 = new BankAccountdto();
		BankTransaction bankTransaction = new BankTransaction();
		BankAccountdao accountdao = new BankAccountdao();
		bankAccountdto2 = accountdao.fetchone(accno);
		double currentamount = bankAccountdto2.getAmount();
		

		if (name.equals(bankAccountdto2.getA3BankUserData().getUserName()) && accno == bankAccountdto2.getAcc_no()) {
			if (bankAccountdto2.isStatus()) {
				if (amount<=bankAccountdto2.getAcc_limit()) {
					if (currentamount > amount) { 
						bankAccountdto2.setAmount(currentamount - amount);
						bankTransaction.setWithdraw(amount);
						bankTransaction.setDeposite(0);
						bankTransaction.setDateTime(LocalDateTime.now());
						bankTransaction.setBalance(bankAccountdto2.getAmount());
						bankTransaction.setMethod("cash");
						List<BankTransaction> transactions=bankAccountdto2.getList();
						transactions.add(bankTransaction);
						bankAccountdto2.setList(transactions);
						accountdao.update(bankAccountdto2);
						req.getSession().setAttribute("msg", "Amount withdrawn");
						req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
					} else {
						req.getSession().setAttribute("msg", "Low balance");
						req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
					}
				} else {
					req.getSession().setAttribute("msg", "Limit excedding");
					req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
				}

			} else {
				req.getSession().setAttribute("msg", "Account is not active");
				req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
			}
		} else {
			req.getSession().setAttribute("msg", "Account number and name doesn't match");
			req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
		}
	}
}
