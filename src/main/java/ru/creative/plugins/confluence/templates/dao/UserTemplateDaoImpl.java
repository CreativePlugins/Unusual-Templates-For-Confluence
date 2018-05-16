package ru.creative.plugins.confluence.templates.dao;


import com.atlassian.activeobjects.external.ActiveObjects;
import lombok.extern.slf4j.Slf4j;
import net.java.ao.DBParam;
import net.java.ao.Query;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class UserTemplateDaoImpl implements UserTemplateDao {
    private final ActiveObjects entityManager;
    private final TagDao tagDao;

    public UserTemplateDaoImpl(ActiveObjects entityManager, TagDao tagDao) {
        this.entityManager = checkNotNull(entityManager);
        this.tagDao = checkNotNull(tagDao);
    }


    @Override
    public UserTemplate getUserTemplate(Integer id) throws SQLException {
        final UserTemplate[] templates = entityManager.find(UserTemplate.class, Query.select().where("ID = ?", id));
        if (templates.length > 1){
            log.error("UserTemplates cannot have two instances with same ID");
        }
        return templates.length > 0 ? templates[0] : null;
    }

    @Override
    public List<UserTemplate> getUserCreatedTemplates(String creator) throws SQLException {
        final Query query = Query.select().where("CREATOR = ?", creator).order("ID DESC");
        return Arrays.asList(entityManager.find(UserTemplate.class, query));
    }

    @Override
    public UserTemplate addUserTemplate(final UserTemplateDto dto) throws SQLException {
        final UserTemplate template = entityManager.create(UserTemplate.class,
                new DBParam("NAME", dto.getName()),
                new DBParam("DESCR", dto.getDescription()),
                new DBParam("BODY", dto.getBody()),
                new DBParam("CREATOR", dto.getCreator())
        );
        setUserTemplateFields(template, dto).save();
        if(!dto.getTags().isEmpty()){
            for(String tag : dto.getTags() ){
                tagDao.associateTagToTemplate(tagDao.getOrCreateTag(tag), template);
            }
        }
        return template;
    }

    @Override
    public UserTemplate updateTemplate(UserTemplateDto dto) throws SQLException {
        UserTemplate template = getUserTemplate(dto.getId());
        template = setUserTemplateFields(template, dto);
        //ToDo: remove tags Arrays.stream(template.getTags()).filter( it -> !dto.getTags().contains(it.getName())).forEach();
        template.save();
        return template;
    }

    @Override
    public void deleteTemplate(UserTemplate template) throws SQLException {
        entityManager.delete(template);
    }

    private UserTemplate setUserTemplateFields(UserTemplate template, UserTemplateDto dto){
        template.setName(dto.getName());
        template.setBody(dto.getBody());
        template.setDescription(dto.getDescription());
        template.setCreator(dto.getCreator());
        return template;
    }
}
