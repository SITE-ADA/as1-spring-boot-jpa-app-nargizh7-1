package az.edu.ada.wm2.model;

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

    // Establishes the other side of a many-to-many relationship with Driver
    @ManyToMany(mappedBy = "teams")
    private Set<Driver> drivers = new HashSet<>();

    // Custom toString method for logging and debugging
    @Override
    public String toString() {
        return "Team: " + name + ", " + country;
    }
}
