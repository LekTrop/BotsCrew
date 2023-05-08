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
public class DepartmentAverageSalaryResponse extends UniversityResponse {
    private final double averageSalary;
    private final String departmentName;

    @Override
    public String toString() {
        return "The average salary of " + departmentName + " is " + averageSalary;
    }
}
