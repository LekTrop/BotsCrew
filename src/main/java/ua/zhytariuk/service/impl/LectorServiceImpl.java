package ua.zhytariuk.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.zhytariuk.models.lector.Lector;
import ua.zhytariuk.repository.LectorRepository;
import ua.zhytariuk.service.LectorService;

import java.util.List;

/**
 * @author (ozhytary)
 */
@RequiredArgsConstructor
@Service
public class LectorServiceImpl implements LectorService {

    @NonNull
    private final LectorRepository lectorRepository;

    @Override
    public List<Lector> findByDepartmentName(final String name) {
        return lectorRepository.findByDepartmentsName(name);
    }

    @Override
    public List<Lector> findByTemplate(final String template) {
        return lectorRepository.findByTemplate(template);
    }
}
