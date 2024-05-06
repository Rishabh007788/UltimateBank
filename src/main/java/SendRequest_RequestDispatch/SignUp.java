/*
 * package SendRequest_RequestDispatch;
 * 
 * import java.io.IOException; import java.sql.Date; import java.util.UUID;
 * 
 * import javax.servlet.GenericServlet; import javax.servlet.ServletException;
 * import javax.servlet.ServletRequest; import javax.servlet.ServletResponse;
 * import javax.servlet.annotation.WebServlet;
 * 
 * import dao.A3BankDao; import dto.A3BankUserData;
 * 
 * @WebServlet() public class SignUp extends GenericServlet {
 * 
 * @Override public void service(ServletRequest req, ServletResponse res) throws
 * ServletException, IOException { // TODO Auto-generated method stub String
 * Name = req.getParameter("Name"); String Email = req.getParameter("Email");
 * String mob = req.getParameter("Mob"); long Mob = Long.parseLong(mob); String
 * dob = req.getParameter("Dob"); Date Dob = Date.valueOf(dob); String Gender =
 * req.getParameter("Gender"); String Password = req.getParameter("Password");
 * 
 * 
 * 
 * 
 * 
 * res.getWriter().println("name : "+Name + "\nEmail : "+Email+ "\nMob : "+Mob+
 * "\nDob : "+ Dob + "\nGender : "+ Gender+ "\nPassword : "+Password);
 * 
 * }
 * 
 * }
 */