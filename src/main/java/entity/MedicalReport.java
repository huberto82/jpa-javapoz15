package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name ="MRfindAll", query = "FROM MedicalReport")
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Timestamp created;

    private String content;

    @ManyToOne
    @JoinColumn(name = "dog_id", referencedColumnName = "id")
    private Dog dog;

    public MedicalReport(String content, Dog dog) {
        this.content = content;
        this.dog = dog;
    }

    public MedicalReport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    @PrePersist
    private void setCreated() {
        this.created = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "id=" + id +
                ", created=" + created +
                ", content='" + content + '\'' +
                ", dog=" + dog +
                '}';
    }
}
