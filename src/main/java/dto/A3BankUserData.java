package dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class A3BankUserData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userID ;
	@Column(nullable = false)
	String UserName ;
	@Column(nullable = false, unique = true)
	String Email;
	@Column(nullable = false, unique = true)
	long MobNo;
	@Column(nullable = false)
	Date Dob ;  
	@Column(nullable = false)
	String Gender ;
	@Column(nullable = false) 
	String Pass;
	@OneToMany
	List<BankAccountdto> bankAccountdtos;
	
	public List<BankAccountdto> getBankAccountdtos() {
		return bankAccountdtos;
	}
	public void setBankAccountdtos(List<BankAccountdto> bankAccountdtos) {
		this.bankAccountdtos = bankAccountdtos;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int uniqueID) {
		this.userID = uniqueID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobNo() {
		return MobNo;
	}
	public void setMobNo(long mobNo) {
		MobNo = mobNo;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public Date getDob() {
		return Dob;
	}
	public void setDob(Date dob) {
		Dob = dob;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	
	
}
