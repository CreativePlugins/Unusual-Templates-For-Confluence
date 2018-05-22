package ru.creative.plugins.confluence.templates.service;

import ru.creative.plugins.confluence.templates.dao.UserTemplateDao;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserTemplatesService {


    private final UserTemplateDao userTemplateDao;

    public UserTemplatesService(UserTemplateDao userTemplateDao) {
        this.userTemplateDao = userTemplateDao;
    }

    public UserTemplateDto addUserTemplate(UserTemplateDto dto) throws SQLException {
        return UserTemplateDto.convert(userTemplateDao.addUserTemplate(dto));
    }

    public List<UserTemplateDto> getUserTemplates(String name) throws SQLException {
        return userTemplateDao.getUserCreatedTemplates(name).stream()
                .map(UserTemplateDto::convert).collect(Collectors.toList());
    }
}
