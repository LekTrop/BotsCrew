package ua.zhytariuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.zhytariuk.models.lector.Lector;

import java.util.List;

/**
 * @author (ozhytary)
 */
public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findByDepartmentsName(final String name);

    @Query(
            "SELECT l FROM lectors l WHERE l.firstName LIKE %:tempalte% " +
                    "OR l.lastName LIKE %:template% "
    )
    List<Lector> findByTemplate(final @Param("template") String template);
}
