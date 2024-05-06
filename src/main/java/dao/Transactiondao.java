package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import dto.BankTransaction;

public class Transactiondao {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction transaction= entityManager.getTransaction();

public void save(BankTransaction bankTransaction) {
	transaction.begin();
	entityManager.persist(bankTransaction);
	transaction.commit();
	
}


}
