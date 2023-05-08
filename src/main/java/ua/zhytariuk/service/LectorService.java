package ua.zhytariuk.service;

import ua.zhytariuk.models.lector.Lector;

import java.util.List;

/**
 * @author (ozhytary)
 */
public interface LectorService {

    List<Lector> findByDepartmentName(final String name);

    List<Lector> findByTemplate(String param);
}
