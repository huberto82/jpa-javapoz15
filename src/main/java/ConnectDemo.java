import entity.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class ConnectDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oko");
        EntityManager em = emf.createEntityManager();
        Dog piesek = new Dog();
        piesek.setName("Reksio");
        piesek.setBirthDate(LocalDate.of(2009, 10, 10));
        em.getTransaction().begin();
        em.persist(piesek);
        em.getTransaction().commit();
        Dog dog = new Dog("Bestia",LocalDate.of(2010, 4,4));
        System.out.println("ID psa przed utrwaleniem: " + dog.getId());
        em.getTransaction().begin();
        em.persist(dog);
        em.getTransaction().commit();
        System.out.println("ID psa po utrwaleniu: " + dog.getId());
        em.close();
        emf.close();
    }
}
