package ua.zhytariuk.models.department;

import jakarta.persistence.*;
import lombok.*;
import ua.zhytariuk.models.lector.Lector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author (ozhytary)
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_lector_id")
    private Lector head;

    @ManyToMany
    @JoinTable(
            name = "lector_departments",
            joinColumns = @JoinColumn(name = "fk_department_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_lector_id")
    )
    private List<Lector> lectors = new ArrayList<>();
}
