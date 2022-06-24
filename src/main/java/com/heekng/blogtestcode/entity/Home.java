package com.heekng.blogtestcode.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    private List<Dog> dogs = new ArrayList<>();
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();

    @Builder
    public Home(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        person.setHome(this);
        this.persons.add(person);
    }
}
