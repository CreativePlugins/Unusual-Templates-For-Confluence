package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.TagToTemplate;

import java.sql.SQLException;

public interface TagDao {

    Tag getTag(String name);

    Tag getOrCreateTag(String name);

    Tag createTag(String name);

    void deleteTag(Tag tag);

    void associateTagToTemplate(Tag tag, AbstractTemplate template);

    void removeTagToTemplateAssociation(Tag tag, AbstractTemplate template);
}
