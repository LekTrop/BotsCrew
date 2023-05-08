package ua.zhytariuk.service;

import ua.zhytariuk.models.department.Department;

/**
 * @author (ozhytary)
 */
public interface DepartmentService {
    Department findByName(final String name);

    int findCountOfLectorsByName(String param);

    Double findAverageSalaryByName(String param);
}
