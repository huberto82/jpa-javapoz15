import dao.DogDao;
import dao.DogDaoJpa;
import entity.Address;
import entity.Dog;
import entity.Owner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneToOneDemo {

    public static void main(String[] args) {
        DogDao dao = new DogDaoJpa();
        Dog dog = new Dog("Lolek", LocalDate.now());
        Address address = new Address();
        address.setCity("Kraków");
        address.setStreet("Poznańska 45/3");
        address.setZipCode("34-749");
        dog.setAddress(address);
        Owner owner = new Owner();
        owner.setName("Kazik");
        dao.save(dog);
        owner.setDog(dog);
        EntityManager em = Persistence.createEntityManagerFactory("oko").createEntityManager();
        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();
    }
}
