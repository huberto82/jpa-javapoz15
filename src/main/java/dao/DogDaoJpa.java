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
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM Dog d WHERE birthDate = :date")
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Dog> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM  Dog d").getResultList();
    }

    @Override
    public Dog findById(long id) {
       EntityManager em = emf.createEntityManager();
       return em.find(Dog.class, id);
    }

    @Override
    public void save(Dog obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void update(Dog obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Dog obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dog dog = em.find(Dog.class, id);
        if (dog != null) {
            em.remove(dog);
        }
        em.getTransaction().commit();
    }
}
