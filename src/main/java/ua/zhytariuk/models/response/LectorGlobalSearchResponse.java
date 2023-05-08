package ua.zhytariuk.models.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import ua.zhytariuk.models.lector.Lector;

import java.util.List;

/**
 * @author (ozhytary)
 */
@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class LectorGlobalSearchResponse extends UniversityResponse {
    private final List<Lector> lectors;

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        lectors.forEach(lector -> {
            stringBuilder.append(lector.getFirstName())
                         .append(lector.getLastName())
                         .append(",");
        });

        return stringBuilder.toString();
    }
}
