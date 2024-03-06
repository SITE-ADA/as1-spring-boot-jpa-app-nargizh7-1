package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TEAMS")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private Integer wins;

    @ManyToMany(mappedBy = "teams")
    private Set<Driver> drivers = new HashSet<>();

    public Team(String name, String country, Integer wins) {
        this.name = name;
        this.country = country;
        this.wins = wins;
    }

    public Team(String name, Integer wins) {
        this(name, name, wins);
    }

    @Override
    public String toString() {
        return "Team: " + this.name + ": " + this.country;
    }
}
