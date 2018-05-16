package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.Tag;

import java.sql.SQLException;

public interface TagDao {

    Tag getTag(String name) throws SQLException;

    Tag getOrCreateTag(String name) throws SQLException;

    Tag createTag(String name) throws SQLException;

    void deleteTag(Tag tag) throws SQLException;

    void associateTagToTemplate(Tag tag, AbstractTemplate template) throws SQLException;
}
