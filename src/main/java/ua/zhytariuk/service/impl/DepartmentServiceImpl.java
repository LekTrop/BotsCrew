package ua.zhytariuk.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.zhytariuk.exception.DepartmentNotExistException;
import ua.zhytariuk.models.department.Department;
import ua.zhytariuk.repository.DepartmentRepository;
import ua.zhytariuk.service.DepartmentService;

/**
 * @author (ozhytary)
 */
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @NonNull
    private final DepartmentRepository departmentRepository;

    @Override
    public Department findByName(final String name) {
        return departmentRepository.findByName(name)
                                   .orElseThrow(() -> new DepartmentNotExistException("Department with name " + name + " does not exist"));
    }

    @Override
    public int findCountOfLectorsByName(final String name) {
        return departmentRepository.findCountOfLectorsByName(name);
    }

    @Override
    public Double findAverageSalaryByName(final String name) {
        final Department department = findByName(name);
        final Double avg = departmentRepository.findLectorsAverageSalaryByName(name);

        return avg == null
                ? 0
                : avg;
    }
}
