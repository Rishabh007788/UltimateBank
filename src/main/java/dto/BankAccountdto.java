package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccountdto { 
	@Id
	@SequenceGenerator(initialValue = 44556321, allocationSize = 1,sequenceName ="accno" ,name = "accno" )
	@GeneratedValue(generator = "accno")
	long acc_no;

	String account_type;
	
	double acc_limit;
	  
	boolean status;
	
	double amount;
	
	int pin;
	
	@ManyToOne
	 A3BankUserData a3BankUserData; 
	
	@OneToMany(cascade = CascadeType.ALL)
	List<BankTransaction> list;
	

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public A3BankUserData getA3BankUserData() {
		return a3BankUserData;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setA3BankUserData(A3BankUserData a3BankUserData) {
		this.a3BankUserData = a3BankUserData;
	}

	public List<BankTransaction> getList() {
		return list;
	}

	public void setList(List<BankTransaction> list) {
		this.list = list;
	}
	

}
