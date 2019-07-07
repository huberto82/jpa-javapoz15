import entity.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class FindDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oko");
        EntityManager em = emf.createEntityManager();

        Dog pies;
        em.getTransaction().begin();
        pies = em.find(Dog.class, 2L);
        em.getTransaction().commit();

        System.out.println(pies);

        em.getTransaction().begin();
        pies.setName("NOWE");
        em.merge(new Dog("Alik", LocalDate.now()));
        em.getTransaction().commit();

        System.out.println(pies);
        em.close();
        emf.close();
    }
}
