package vn.edu.iuh.fit.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Connection {

  private final EntityManager entityManager;
  private final EntityTransaction transaction;
  private static Connection instance;

  private Connection() {
    entityManager = Persistence.createEntityManagerFactory("www-lab-week02").createEntityManager();
    transaction = entityManager.getTransaction();
  }

  public static Connection getInstance() {
    if (instance == null) {
      instance = new Connection();
    }
    return instance;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public EntityTransaction getTransaction() {
    return transaction;
  }
}
