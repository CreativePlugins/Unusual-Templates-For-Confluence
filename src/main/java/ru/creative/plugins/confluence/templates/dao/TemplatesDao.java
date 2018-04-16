package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.Template;

import java.util.Set;

public interface TemplatesDao {

    Template getTemplateById(Integer id);

    Template[] getUserTemplates(String creator);

    void deleteTemplate(Template template);

    void deleteTemplateById(Integer id);

    Template updateTemplate(Template template);

    Template createOrUpdateTemplate(Template template, String name, String description, String type, String body, String templateType, String creator, Set<Tag> tags);
}
