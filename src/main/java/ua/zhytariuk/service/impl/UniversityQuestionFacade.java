package ua.zhytariuk.service.impl;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import ua.zhytariuk.exception.RequestNotExistException;
import ua.zhytariuk.models.department.Department;
import ua.zhytariuk.models.lector.Lector;
import ua.zhytariuk.models.response.*;
import ua.zhytariuk.service.DepartmentService;
import ua.zhytariuk.service.LectorService;

import java.util.stream.Collectors;

import static ua.zhytariuk.common.QuestionInputsConstance.*;

/**
 * @author (ozhytary)
 */
@Component
public class UniversityQuestionFacade {

    private final LectorService lectorService;
    private final DepartmentService departmentService;

    public UniversityQuestionFacade(final LectorService lectorService,
                                    final DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public UniversityResponse getResponseByUserRequest(final Pair<String, String> requestParamPair) {
        final String requestQuery = requestParamPair.getFirst();
        final String param = requestParamPair.getSecond();

        switch (requestQuery) {
            case FIND_HEAD_OF_DEPARTMENT_BY_NAME -> {
                final Department department = departmentService.findByName(param);
                return new DepartmentHeadResponse(department.getName(), department.getHead()
                                                                                  .getFirstName());
            }
            case SHOW_EMPLOYEE_COUNT_FOR_DEPARTMENT -> {
                return new DepartmentEmployeeCountResponse(departmentService.findCountOfLectorsByName(param));
            }
            case SHOW_DEPARTMENT_STATISTIC -> {
                final var statistic =
                        lectorService.findByDepartmentName(param)
                                     .stream()
                                     .collect(Collectors.groupingBy(Lector::getDegree, Collectors.toList()));

                return new DepartmentStatisticResponse(statistic);
            }
            case GLOBAL_SEARCH_BY -> {
                return new LectorGlobalSearchResponse(lectorService.findByTemplate(param));
            }
            case SHOW_AVERAGE_SALARY_FOR_DEPARTMENT -> {
                return new DepartmentAverageSalaryResponse(departmentService.findAverageSalaryByName(param), param);
            }
            default -> {
                throw new RequestNotExistException("Sorry but we not support this request");
            }
        }
    }
}
