package dao;

import entity.Dog;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DogDaoSet implements DogDao{

    private Set<Dog> dogs = new HashSet<>();
    static private long id = 1;

    public long nextId(){
        return ++id;
    }


    @Override
    public List<Dog> findByBirhDate(LocalDate date) {
        return null;
    }

    @Override
    public void updatedCreated(Timestamp date) {

    }

    @Override
    public List<Dog> findAll() {
        return null;
    }

    @Override
    public Dog findById(long id) {
        return dogs.stream().filter(dog -> dog.getId() == id).findFirst().get();
    }

    @Override
    public void save(Dog obj) {
        obj.setId(nextId());
        dogs.add(obj);
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
