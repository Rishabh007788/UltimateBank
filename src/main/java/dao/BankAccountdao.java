
	package dao;


	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.A3BankUserData;
import dto.BankAccount;
import dto.BankAccountdto;

	public class BankAccountdao { 
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
public void save(BankAccountdto bankAccountdto) {
	entityTransaction.begin();
	entityManager.persist(bankAccountdto); 
	entityTransaction.commit();
}
public void saveacc(BankAccount account) {
	entityTransaction.begin();
	entityManager.persist(account); 
	entityTransaction.commit();
}

public List<BankAccountdto> fetchall() {
	List<BankAccountdto> list = entityManager.createQuery("select x from BankAccountdto x ").getResultList();
	return list;
}
public BankAccountdto fetchone(long accno) {
	BankAccountdto bankAccountdto = entityManager.find(BankAccountdto.class, accno);
	return bankAccountdto;
}
public void update(BankAccountdto accountdto) {
	entityTransaction.begin();
	entityManager.merge(accountdto);
	entityTransaction.commit();
	
}

public List<BankAccountdto> fetchSavingAcc() {
	List<BankAccountdto> list = entityManager.createQuery("select x from BankAccountdto x where account_type=?1").setParameter(1, "saving").getResultList();
	return list;
}

public List<BankAccountdto> fetchCurrentAcc() {
	List<BankAccountdto> list = entityManager.createQuery("select x from BankAccountdto x where account_type=?1").setParameter(1, "current").getResultList();
	return list;
}

		} 

