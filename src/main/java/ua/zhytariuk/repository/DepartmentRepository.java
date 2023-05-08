package ua.zhytariuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.zhytariuk.models.department.Department;

import java.util.Optional;

/**
 * @author (ozhytary)
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(final String name);

    int findCountOfLectorsByName(final String name);

    @Query("SELECT AVG(dl.salary) FROM departments d INNER JOIN d.lectors dl")
    Double findLectorsAverageSalaryByName(final String param);
}
