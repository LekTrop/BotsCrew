package ua.zhytariuk.service.impl;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import ua.zhytariuk.exception.RequestNotExistException;

import static ua.zhytariuk.common.QuestionInputsConstance.*;

/**
 * @author (ozhytary)
 */
@Component
public class MessageMatcher {
    public Pair<String, String> converToPairIfMatch(final String request) {
        if (request.matches("^Who is head of department\\s+\\w+")) {
            return Pair.of(FIND_HEAD_OF_DEPARTMENT_BY_NAME, getLastWord(request));
        }

        if (request.matches("^Show\\s+\\w+\\s+statistics")) {
            return Pair.of(SHOW_DEPARTMENT_STATISTIC, request.split("\\s+")[1]);
        }

        if (request.matches("^Show the average salary for the department\\s+\\w+")) {
            return Pair.of(SHOW_AVERAGE_SALARY_FOR_DEPARTMENT, getLastWord(request));
        }

        if (request.matches("^Show count of employee for\\s+\\w+")) {
            return Pair.of(SHOW_EMPLOYEE_COUNT_FOR_DEPARTMENT, getLastWord(request));
        }

        if (request.matches("^Global search by\\s+\\w+")) {
            return Pair.of(GLOBAL_SEARCH_BY, getLastWord(request));
        }

        throw new RequestNotExistException("Request " + request + " does not exist");
    }

    private String getLastWord(final String request) {
        return request.substring(request.lastIndexOf(" ") + 1);
    }
}
