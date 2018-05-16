package ru.creative.plugins.confluence.templates.dao;

import lombok.extern.slf4j.Slf4j;
import net.java.ao.EntityManager;
import net.java.ao.Query;
import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.TagToTemplate;

import java.sql.SQLException;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class TagDaoImpl implements TagDao {
    private final EntityManager entityManager;

    public TagDaoImpl(EntityManager entityManager) {
        this.entityManager = checkNotNull(entityManager);
    }

    @Override
    public Tag getTag(final String name) throws SQLException {
        final Tag[] tags = entityManager.find(Tag.class, Query.select().where("name = ?", name));
        if (tags.length > 1){
            log.error("Cannot have two tags with same name");
        }
        return tags.length > 0 ? tags[0] : null;
    }

    @Override
    public Tag getOrCreateTag(final String name) throws SQLException {
        final Tag t = getTag(name);
        return t != null ? t : createTag(name);
    }

    @Override
    public Tag createTag(String name) throws SQLException {
        final Tag tag = entityManager.create(Tag.class);
        tag.setName(name);
        //ToDo: check if save needed
        //tag.save();
        return tag;
    }

    @Override
    public void deleteTag(final Tag tag) throws SQLException {
        entityManager.delete(tag);
    }

    @Override
    public void associateTagToTemplate(Tag tag, AbstractTemplate template) throws SQLException {
        final TagToTemplate tagToTemplate = entityManager.create(TagToTemplate.class);
        tagToTemplate.setTag(tag);
        tagToTemplate.setTemplate(template);
        tagToTemplate.save();
    }
}
