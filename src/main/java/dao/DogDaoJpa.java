package dao;

import entity.Dog;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class DogDaoJpa implements DogDao{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oko");

    @Override
    public List<Dog> findByBirhDate(LocalDate date) {
        return null;
    }

    @Override
    public Dog findById(long id) {
       EntityManager em = emf.createEntityManager();
       return em.find(Dog.class, id);
    }


    @Override
    public void save(Dog obj) {

    }

    @Override
    public void update(Dog obj) {

    }

    @Override
    public void delete(Dog obj) {

    }

    @Override
    public void delete(long id) {

    }
}
