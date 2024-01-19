/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package test.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

  public static void main(String[] args) {
    addUser();
    getUser();
  }

  /** 유저 조회 */
  public static void getUser() {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("example-unit");

    // emFactory 잘 가져 왔는지 체크
    System.out.println("isOpen() :" + emFactory.isOpen());

    EntityManager em = emFactory.createEntityManager();
    try {
      em.getTransaction().begin();

      List<UserA> users = em.createQuery("from UserA", UserA.class).getResultList();
      users.stream().forEach(user -> System.out.println(user.getName()));

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();

      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  /** 유저 추가 */
  public static void addUser() {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("example-unit");

    // emFactory 잘 가져 왔는지 체크
    System.out.println("isOpen() :" + emFactory.isOpen());

    EntityManager em = emFactory.createEntityManager();
    try {
      em.getTransaction().begin();

      UserA user = new UserA();
      user.setId(1l);
      user.setName("홍길동1");
      user.setEmail("hong@example.com1");
      em.persist(user);

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();

      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }
}
