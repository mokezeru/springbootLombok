package com.charter.springbootLombok.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter // <--- This is for lombok getters and setters
@Builder // <-- for Lombok builder pattern
@NoArgsConstructor // mostly used to create a constructor with different access modification
@AllArgsConstructor // will create constructor receiving all non-static fields
//@RequiredArgsConstructor // will create constructor receiving non-static final fields.
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    private static final long serialVersionUID = -5091234194436948032L;

    private @Id Long id; // will be set when persisting
    private String firstName;
    private String lastName;
    private int age;

}