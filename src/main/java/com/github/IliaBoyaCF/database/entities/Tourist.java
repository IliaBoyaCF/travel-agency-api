package com.github.IliaBoyaCF.database.entities;

import jakarta.persistence.*;

@Entity
@Table(name="\"Tourists\"")
public class Tourist {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="\"firstname\"")
    private String firstname;

    @Column(name="\"passport_data\"")
    private String passportData;

    @Column(name="\"gender\"")
    private String gender;

    public Tourist() {}

    public Tourist(String firstname, String passportData, String gender) {
        this.firstname = firstname;
        this.passportData = passportData;
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassportData() {
        return passportData;
    }

    public String getGender() {
        return gender;
    }
}
