package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name = "findAll", query = "FROM Dog")
@NamedQuery(name = "findByName", query = "SELECT d FROM Dog d WHERE d.name = :name")
@NamedQuery(name = "updateCreated", query = "UPDATE Dog d SET d.created = :date WHERE d.created is NULL")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private LocalDate birthDate;

    private Timestamp created;

    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Dog() {
    }

    public Timestamp getCreated() {
        return created;
    }

    public Dog(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "entity.Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @PrePersist
    private void setCreated(){
        created = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreRemove
    private void byeBye(){
        System.out.println("Żegnaj piesku + " + name);
    }
}

//TODO napisać NamedQuery zwracające liczbę psów w tabeli
//TODO napisać NamedQuery zwracające psy posortowane rosnąco wg datyurodzin i imienia
//TODO napisać NamedQuery zwracające najstarszego psa
//TODO napisać metodę zwracające tabelę wszystkich psów: imię i wiek
