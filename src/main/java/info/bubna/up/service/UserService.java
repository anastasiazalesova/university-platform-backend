package info.bubna.up.service;

import info.bubna.up.dao.DisciplineDao;
import info.bubna.up.dao.MarkDao;
import info.bubna.up.dto.WebDisciplineDTO;
import info.bubna.up.dto.WebMarkDTO;
import info.bubna.up.ex.UserNotFoundException;
import info.bubna.up.gen.tables.daos.RecUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MarkDao markDao;
    private final RecUserDao userDao;
    private final DisciplineDao disciplineDao;
    private final ConversionService conversionService;

    public List<WebDisciplineDTO> getDisciplines(UUID id) {
        if (!userDao.existsById(id)) throw new UserNotFoundException(id);

        return disciplineDao.fetchByUserId(id).stream()
                .map(it -> conversionService.convert(it, WebDisciplineDTO.class))
                .collect(Collectors.toList());
    }

    public List<WebMarkDTO> getMarks(UUID id) {
        if (!userDao.existsById(id)) throw new UserNotFoundException(id);

        return markDao.fetchByUserId(id).stream()
                .map(it -> conversionService.convert(it, WebMarkDTO.class))
                .collect(Collectors.toList());
    }
}
