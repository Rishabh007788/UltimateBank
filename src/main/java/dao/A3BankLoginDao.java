package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dto.A3BankUserData;

public class A3BankLoginDao {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
EntityManager entityManager = entityManagerFactory.createEntityManager();
public List<A3BankUserData> check() {
	List<A3BankUserData> list = entityManager.createQuery("select x from A3BankUserData x where Email=/1").getResultList();
	return list;
}

}
