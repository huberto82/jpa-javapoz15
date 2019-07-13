package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Timestamp created;

    private String content;

    public MedicalReport( String content) {
        this.content = content;
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
}
