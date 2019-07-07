import dao.DogDao;
import dao.DogDaoJpa;
import entity.Dog;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DaoDemo {
    public static void main(String[] args) {

        DogDao dogDao = new DogDaoJpa();
        /*
        //dogDao.save(new Dog("Czarny", LocalDate.of(2005,10,1)));
        Dog dog = dogDao.findById(2L);
        System.out.println("Pies o id 2: " + dog);
        dog.setName("Fafik");
        dogDao.update(dog);

        System.out.println("Pies o id 2 po zmianie imienia: " + dogDao.findById(2L));
        for(Dog d: dogDao.findAll()) {
            System.out.println(d);
        }

        System.out.println("Psy urodzone tego samego dnia 2000-09-30");
        for(Dog d: dogDao.findByBirhDate(LocalDate.of(2009,10,9))){
            System.out.println(d);
        }

        System.out.println("Lista psów z NamedQuery");
        EntityManager em = Persistence.createEntityManagerFactory("oko").createEntityManager();

        List<Dog> lista = em.createNamedQuery("findAll", Dog.class).getResultList();
        for(Dog d: lista){
            System.out.println(d);
        }
        */

        dogDao.updateCreated(Timestamp.valueOf(LocalDateTime.now()));
        for(Dog d: dogDao.findAll()) {
            System.out.println(d);
        }
    }
}
