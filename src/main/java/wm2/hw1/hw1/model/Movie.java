package wm2.hw1.hw1.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    private String country;

    private Integer wins;

    @ManyToMany(mappedBy = "movies")
    private Set<Director> directors = new HashSet<>();

    public Movie(String name, String country, Integer wins) {
        this.name = name;
        this.country = country;
        this.wins = wins;
    }

    public Movie(String name, Integer wins) {
        this(name, name, wins);
    }

    @Override
    public String toString() {
        return "Movie: " + this.name + ": " + this.country;
    }
}
