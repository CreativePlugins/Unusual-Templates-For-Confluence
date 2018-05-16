package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

import java.sql.SQLException;
import java.util.List;

public interface UserTemplateDao {

    UserTemplate getUserTemplate(Integer id) throws SQLException;

    List<UserTemplate> getUserCreatedTemplates(String creator) throws SQLException;

    UserTemplate addUserTemplate(UserTemplateDto template) throws SQLException;

    UserTemplate updateTemplate(UserTemplateDto dto) throws SQLException;

    void deleteTemplate(UserTemplate template) throws SQLException;
}
