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
@WebServlet("/open_acc")
public class BankAccountcontroll extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String accountType = req.getParameter("accounttype");
	int pin = Integer.parseInt(req.getParameter("pin"));
	A3BankUserData a3BankUserData =(A3BankUserData) req.getSession().getAttribute("A3BankUserData");
	List<BankAccountdto> list = a3BankUserData.getBankAccountdtos();
	
	boolean flag = true;
	for (BankAccountdto bankAccountdto : list) {
		if (bankAccountdto.getAccount_type().equals(accountType)) {
			flag=false;
			break;
		}
		
	} 
	if (flag) 
		{
			BankAccountdto bankAccountdto = new BankAccountdto();
			bankAccountdto.setAccount_type(accountType);
			if (bankAccountdto.getAccount_type().equals("saving")) 
					bankAccountdto.setAcc_limit(500000);
			else 
					bankAccountdto.setAcc_limit(1000000);	
			bankAccountdto.setPin(pin);
			
			bankAccountdto.setA3BankUserData(a3BankUserData); 
			List<BankAccountdto> list2 = list; 
			list2.add(bankAccountdto);
			a3BankUserData.setBankAccountdtos(list2);
			
			BankAccountdao bankAccountdao = new BankAccountdao();
			A3BankDao a3BankDao = new A3BankDao();
			bankAccountdao.save(bankAccountdto);
			a3BankDao.update(a3BankUserData);
			req.getSession().setAttribute("accOpenMsg", "your account opening form has been submitted. Wait for manager validation. Once your account status is Active you can do the transaction. ");
			req.getRequestDispatcher("commonresponse.jsp").forward(req, resp);
		}
	else 
		{
		req.getSession().setAttribute("accOpenMsg", "you already have a "+accountType+" account");
		req.getRequestDispatcher("accountopenmsg.jsp").forward(req, resp);
		}
	
	
}
}
