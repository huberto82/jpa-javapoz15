import dao.DogDao;
import dao.DogDaoJpa;
import dao.DogDaoSet;
import entity.Dog;

import java.time.LocalDate;

public class DaoDemo {
    public static void main(String[] args) {
        DogDao dogDao = new DogDaoJpa();
        dogDao.save(new Dog("Fafik", LocalDate.of(2000,10,1)));
        Dog dog = dogDao.findById(2L);
        System.out.println("Pies o id 2: " + dog);
        dog.setName("Fafik");
        dogDao.update(dog);
        System.out.println("Pies o id 2 po zmianie imienia: " + dogDao.findById(2L));
        for(Dog d: dogDao.findAll()){
            System.out.println(d);
        }
    }
}
