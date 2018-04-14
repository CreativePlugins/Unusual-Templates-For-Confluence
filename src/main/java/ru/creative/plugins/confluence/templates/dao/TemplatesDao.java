package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.Template;

import java.util.Set;

public interface TemplatesDao {

    Template getTemplateById(Integer id, String creator);

    void deleteTemplate(Template template);

    Template updateTemplate(Template template);

    Template createTemplate(String name, String description, String type, String body, String templateType, String creator, Set<Tag> tags);

}
