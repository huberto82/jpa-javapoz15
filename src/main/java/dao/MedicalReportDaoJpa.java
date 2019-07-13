package dao;

import entity.Dog;
import entity.MedicalReport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MedicalReportDaoJpa implements MedicalReportDao{

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oko");
    @Override
    public List<MedicalReport> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("MRfindAll", MedicalReport.class).getResultList();
    }

    @Override
    public MedicalReport findById(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(MedicalReport.class, id);
    }

    @Override
    public void save(MedicalReport obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void update(MedicalReport obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(MedicalReport obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<MedicalReport> findByDogId(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dog dog = em.find(Dog.class, id);
        List<MedicalReport> list = em.createQuery("SELECT m FROM MedicalReport m WHERE dog = :dog_id").setParameter("dog_id", dog).getResultList();
        em.getTransaction().commit();
        return list;
    }
}
