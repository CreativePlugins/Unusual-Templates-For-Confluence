package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

import java.sql.SQLException;
import java.util.List;

public interface UserTemplateDao {

    UserTemplate getUserTemplate(Integer id);

    List<UserTemplate> getUserCreatedTemplates(String creator);

    UserTemplate addUserTemplate(UserTemplateDto template);

    UserTemplate updateUserTemplate(UserTemplateDto dto);

    void deleteTemplate(AbstractTemplate template);
}
