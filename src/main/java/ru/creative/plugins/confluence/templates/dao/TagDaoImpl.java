package ru.creative.plugins.confluence.templates.dao;

import com.atlassian.activeobjects.external.ActiveObjects;
import lombok.extern.slf4j.Slf4j;
import net.java.ao.DBParam;
import net.java.ao.Query;
import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.TagToTemplate;

import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class TagDaoImpl implements TagDao {
    private final ActiveObjects entityManager;

    public TagDaoImpl(ActiveObjects entityManager) {
        this.entityManager = checkNotNull(entityManager);
    }

    @Override
    public Tag getTag(final String name) {
        final Tag[] tags = entityManager.find(Tag.class, Query.select().where("name = ?", name));
        if (tags.length > 1){
            log.error("Cannot have two tags with same name");
        }
        return tags.length > 0 ? tags[0] : null;
    }

    @Override
    public Tag getOrCreateTag(final String name) {
        final Tag t = getTag(name);
        return t != null ? t : createTag(name);
    }

    @Override
    public Tag createTag(String name) {
        final Tag tag = entityManager.create(Tag.class, new DBParam("NAME", name));
        tag.save();
        return tag;
    }

    @Override
    public void deleteTag(final Tag tag) {
        entityManager.delete(tag);
    }

    @Override
    public void associateTagToTemplate(Tag tag, AbstractTemplate template) {
        final TagToTemplate tagToTemplate = entityManager.create(TagToTemplate.class);
        tagToTemplate.setTag(tag);
        tagToTemplate.setAbstractTemplate(template);
        tagToTemplate.save();
    }

    @Override
    public void removeTagToTemplateAssociation(Tag tag, AbstractTemplate template){
        final TagToTemplate[] tagToTemplates = entityManager.find(TagToTemplate.class,
                Query.select().where("TAG_ID = ? AND ABSTRACT_TEMPLATE_ID = ?", tag.getID(), template.getID()));
        if (tagToTemplates.length > 1){
            log.error("Cannot have two tags to template association with same name");
        }
        if(tagToTemplates.length == 1){
            entityManager.delete(tagToTemplates[0]);
        }
    }
}
