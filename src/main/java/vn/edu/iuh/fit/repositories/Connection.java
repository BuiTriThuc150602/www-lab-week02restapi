package vn.edu.iuh.fit.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Connection {

  private EntityManager entityManager;

  public static void main(String[] args) {
    try{
    Persistence.createEntityManagerFactory("www-lab-week02").createEntityManager();
    }catch (Exception e){e.printStackTrace();}
  }


}
