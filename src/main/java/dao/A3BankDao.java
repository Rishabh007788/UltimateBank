package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.A3BankUserData;

public class A3BankDao {
	EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	   public void save(A3BankUserData a3BankUserData)
	   {
		entityTransaction.begin();
		entityManager.persist(a3BankUserData);
		entityTransaction.commit();
	}
	   public List<A3BankUserData> check1(String email) {
		   List<A3BankUserData> list = entityManager.createQuery("select x from A3BankUserData x where Email=?1").setParameter(1, email).getResultList();
		   return list;
	   }
	   public List<A3BankUserData> check2(long mob) {
		   List<A3BankUserData> list = entityManager.createQuery("select x from A3BankUserData x where MobNo=?1").setParameter(1, mob).getResultList();
		   return list;
	   }
	   public void update(A3BankUserData a3BankUserData) {
			entityTransaction.begin();
			entityManager.merge(a3BankUserData);
			entityTransaction.commit(); 
	}
	public List<A3BankUserData> fetchall() {
		 List<A3BankUserData> list = entityManager.createQuery("select x from A3BankUserData x ").getResultList();
		   return list;
	}
	   

} 
