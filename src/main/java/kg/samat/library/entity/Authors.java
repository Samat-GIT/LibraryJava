package kg.samat.library.entity;

import kg.samat.library.entity.dto.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name ="authors")
@AllArgsConstructor
@NoArgsConstructor
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Authors(AuthorDto authorDto){
        this.firstName = authorDto.getFirstName();
        this.lastName = authorDto.getLastName();
    }

}
