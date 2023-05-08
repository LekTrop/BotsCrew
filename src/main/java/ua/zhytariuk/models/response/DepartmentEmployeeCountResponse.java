package ua.zhytariuk.models.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author (ozhytary)
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class DepartmentEmployeeCountResponse extends UniversityResponse {
    private final int count;

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
