package wm2.hw1.hw1.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    private Set<Movie> movie;
}

