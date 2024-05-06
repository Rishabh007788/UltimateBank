package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.A3BankUserData;
import dto.BankAccountdto;
@WebServlet("/fetchactiveaccount")
public class FetchActiveAccounts extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	A3BankUserData a3BankUserData =  (A3BankUserData) req.getSession().getAttribute("A3BankUserData");
	List<BankAccountdto> list = a3BankUserData.getBankAccountdtos();
	List<BankAccountdto> list2 = new ArrayList<BankAccountdto>();
	
	for (BankAccountdto bankAccountdto : list) {
		if (bankAccountdto.isStatus()) {
			list2.add(bankAccountdto);
			System.out.println("status is active");
		}
	}
	req.getSession().setAttribute("activeAccounts", list2);
	req.getRequestDispatcher("Account.jsp").forward(req, resp);
	
}
}
