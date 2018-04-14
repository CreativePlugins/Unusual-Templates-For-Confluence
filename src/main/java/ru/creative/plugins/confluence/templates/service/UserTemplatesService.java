package ru.creative.plugins.confluence.templates.service;

import ru.creative.plugins.confluence.templates.dao.TemplatesDao;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.model.Template;

public class UserTemplatesService {


    private final TemplatesDao templatesDao;

    public UserTemplatesService(TemplatesDao templatesDao) {
        this.templatesDao = templatesDao;
    }

    public Template saveUserTemplate(UserTemplateDto userTemplateDto) {
        Template template = templatesDao.getTemplateById(userTemplateDto.getId(), userTemplateDto.getCreator());
        if(template == null){
            templatesDao.createTemplate(userTemplateDto.getName(), userTemplateDto.getDescription(), userTemplateDto.getType(),
                    userTemplateDto.getBody(), userTemplateDto.getType(), userTemplateDto.getCreator(), userTemplateDto.getTags());
        }
        return template;
    }
}
