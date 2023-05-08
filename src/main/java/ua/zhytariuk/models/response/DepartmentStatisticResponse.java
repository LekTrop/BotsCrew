package ua.zhytariuk.models.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import ua.zhytariuk.models.lector.Degree;
import ua.zhytariuk.models.lector.Lector;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static ua.zhytariuk.models.lector.Degree.*;

/**
 * @author (ozhytary)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class DepartmentStatisticResponse extends UniversityResponse {
    private static final String DELIMITER = "-";
    private final Map<Degree, List<Lector>> lectorsByDegree;

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(ASSISTANT.getName())
                     .append(DELIMITER)
                     .append(lectorsByDegree.getOrDefault(ASSISTANT, Collections.emptyList()).size())
                     .append(System.lineSeparator());

        stringBuilder.append(ASSOCIATE_PROFESSOR.getName())
                     .append(DELIMITER)
                     .append(lectorsByDegree.getOrDefault(ASSOCIATE_PROFESSOR, Collections.emptyList()).size())
                     .append(System.lineSeparator());

        stringBuilder.append(PROFESSOR.getName())
                     .append(DELIMITER)
                     .append(lectorsByDegree.getOrDefault(PROFESSOR, Collections.emptyList()).size())
                     .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
