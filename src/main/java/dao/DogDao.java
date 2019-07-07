package dao;

import entity.Dog;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface DogDao extends Dao<Dog> {
    List<Dog> findByBirhDate(LocalDate date);
    void updatedCreated(Timestamp date);
}
