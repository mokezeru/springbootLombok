package com.charter.springbootLombok.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor // <--- This is for lombok
public class User implements Serializable {

    private static final long serialVersionUID = -5091234194436948032L;

    private @Id Long id; // will be set when persisting
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters: ~30 extra lines of code ~ Thanks lombok
}