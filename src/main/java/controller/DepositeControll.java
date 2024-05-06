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

@WebServlet("/deposite")
public class DepositeControll extends HttpServlet {
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String name=  req.getParameter("name");
  long accno = Long.parseLong(req.getParameter("acno"));
   long amount=Long.parseLong(req.getParameter("amount")) ;
   
   
   BankAccountdto bankAccountdto2 = new BankAccountdto();
   BankAccountdao accountdao = new BankAccountdao();
   BankTransaction bankTransaction = new BankTransaction();
   bankAccountdto2=accountdao.fetchone(accno);
   if (name.equals(bankAccountdto2.getA3BankUserData().getUserName()) && accno==bankAccountdto2.getAcc_no()) {
	if (bankAccountdto2.isStatus()) {
		bankAccountdto2.setAmount(bankAccountdto2.getAmount()+ amount);
		 
		bankTransaction.setDeposite(amount);
		bankTransaction.setWithdraw(0);
		bankTransaction.setBalance(bankAccountdto2.getAmount());
		bankTransaction.setDateTime(LocalDateTime.now());
		bankTransaction.setMethod("cash");
		List<BankTransaction> transactions=bankAccountdto2.getList();
		transactions.add(bankTransaction);
		bankAccountdto2.setList(transactions);
	    accountdao.update(bankAccountdto2);
	    System.out.println("amount deposited");
	    req.getSession().setAttribute("msg", "Balance deposited");
		req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
	} else {
					req.getSession().setAttribute("msg", "Account is not active");
					req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
					}
   }else {
	   			req.getSession().setAttribute("msg", "Account number and name doesn't match");
	   			req.getRequestDispatcher("Deposite.jsp").forward(req, resp);
   	}
   
   
    }


}
