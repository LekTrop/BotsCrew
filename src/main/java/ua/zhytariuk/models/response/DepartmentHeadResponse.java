package ua.zhytariuk.models.response;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * @author (ozhytary)
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Value
public class DepartmentHeadResponse extends UniversityResponse {
    String departmentName;
    String headName;

    @Override
    public String toString() {
        return "Head of " + departmentName + " department is " + headName;
    }
}
