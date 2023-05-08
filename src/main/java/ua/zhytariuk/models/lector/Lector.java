package ua.zhytariuk.models.lector;

import jakarta.persistence.*;
import lombok.*;
import ua.zhytariuk.models.department.Department;

import java.math.BigDecimal;
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
@Entity(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lector_id")
    private Long lectorId;
    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private Degree degree;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "lector_departments",
            joinColumns = @JoinColumn(name = "fk_lector_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_department_id")
    )
    private List<Department> departments = new ArrayList<>();
}
