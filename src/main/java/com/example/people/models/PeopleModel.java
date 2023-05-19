package com.example.people.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PEOPLE")
public class PeopleModel implements Serializable {

    private static final long serialVersonUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 30)
    private String peopleName;
    @Column(nullable = false, length = 30)
    private String peopleEmail;
    @Column(nullable = false, length = 30)
    private String peoplePassword;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleEmail() {
        return peopleEmail;
    }

    public void setPeopleEmail(String peopleEmail) {
        this.peopleEmail = peopleEmail;
    }

    public String getPeoplePassword() {
        return peoplePassword;
    }

    public void setPeoplePassword(String peoplePassword) {
        this.peoplePassword = peoplePassword;
    }
}
