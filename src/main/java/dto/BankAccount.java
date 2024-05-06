package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {
	@Id
	@SequenceGenerator(initialValue = 44556321, allocationSize = 1,sequenceName ="accno" ,name = "accn" )
	@GeneratedValue(generator = "accn")
	long acc_no;
	    private String accountType;
	    long acclimit;
	    private byte[] photo; // Changed to byte array for storing photo data
	    private byte[] signaturePath;
	    private String pin;
	    @ManyToOne
	    A3BankUserData a3BankUserData;
		
		
	    
}
