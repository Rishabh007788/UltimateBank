package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankAccountdao;
import dto.BankAccountdto;
@WebServlet("/changestatus")
public class ChangeAccountStatus  extends HttpServlet{

@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String accno = req.getParameter("accno");
	long accnum= Long.parseLong(accno);
	BankAccountdao accountdao = new BankAccountdao();
	BankAccountdto accountdto = accountdao.fetchone(accnum);
	if (accountdto.isStatus()) {
		accountdto.setStatus(false);
	} else {
		accountdto.setStatus(true);
	}
	
	accountdao.update(accountdto);
	List<BankAccountdto> list = accountdao.fetchall();
	req.getSession().setAttribute("list", list);
	req.getRequestDispatcher("seeallaccounts.jsp").forward(req, res);
	
}
}
