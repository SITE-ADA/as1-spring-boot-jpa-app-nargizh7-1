package wm2.hw1.hw1.model;

import lombok.*;
import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer credits;

    public Movie(String name, String description, Integer credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Movie(String name, Integer credits) {
        this(name, name, credits);
    }
}
