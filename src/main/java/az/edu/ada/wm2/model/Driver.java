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
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    // Defines a many-to-many relationship with Team
    @ManyToMany
    @JoinTable(name = "driver_team",
            joinColumns = {@JoinColumn(name = "driver_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")}
    )
    private Set<Team> teams = new HashSet<>();

    // Custom toString method for logging and debugging
    @Override
    public String toString() {
        return "Driver: " + firstName + ", " + lastName;
    }
}
