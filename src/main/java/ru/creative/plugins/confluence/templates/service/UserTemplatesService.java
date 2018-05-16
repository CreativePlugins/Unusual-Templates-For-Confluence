package ru.creative.plugins.confluence.templates.service;

import ru.creative.plugins.confluence.templates.dao.UserTemplateDao;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

import java.sql.SQLException;
import java.util.List;

public class UserTemplatesService {


    private final UserTemplateDao userTemplateDao;

    public UserTemplatesService(UserTemplateDao userTemplateDao) {
        this.userTemplateDao = userTemplateDao;
    }

    public UserTemplate addUserTemplate(UserTemplateDto dto) throws SQLException {
        return userTemplateDao.addUserTemplate(dto);
    }

    public List<UserTemplate> getUserTemplates(String name) throws SQLException {
        return userTemplateDao.getUserCreatedTemplates(name);
    }
}
