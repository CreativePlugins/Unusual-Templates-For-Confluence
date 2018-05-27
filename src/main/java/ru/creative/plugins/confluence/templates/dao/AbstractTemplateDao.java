package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.model.AbstractTemplate;

import java.util.Set;

public interface AbstractTemplateDao {
    void deleteTemplate(AbstractTemplate template);

    <T extends AbstractTemplate> T getTemplate(Integer id, Class<T> clazz);

    void smartTagAssociationsRemove(AbstractTemplate template, Set<String> dtoTags);

}
