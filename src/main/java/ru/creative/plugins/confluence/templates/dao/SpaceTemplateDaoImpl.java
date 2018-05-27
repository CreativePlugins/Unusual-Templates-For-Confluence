package ru.creative.plugins.confluence.templates.dao;

import com.atlassian.activeobjects.external.ActiveObjects;
import lombok.extern.slf4j.Slf4j;
import net.java.ao.DBParam;
import net.java.ao.Query;
import ru.creative.plugins.confluence.templates.dto.SpaceTemplateDto;
import ru.creative.plugins.confluence.templates.model.SpaceTemplate;
import ru.creative.plugins.confluence.templates.util.StatusModel;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class SpaceTemplateDaoImpl implements SpaceTemplateDao {
    private final ActiveObjects entityManager;
    private final TagDao tagDao;
    private final AbstractTemplateDao templateDao;

    public SpaceTemplateDaoImpl(ActiveObjects entityManager, TagDao tagDao, AbstractTemplateDao templateDao) {
        this.entityManager = checkNotNull(entityManager);
        this.tagDao = checkNotNull(tagDao);
        this.templateDao = checkNotNull(templateDao);
    }

    @Override
    public SpaceTemplate getSpaceTemplate(Integer id) {
        return templateDao.getTemplate(id, SpaceTemplate.class);
    }

    @Override
    public List<SpaceTemplate> getSpaceTemplates(Long spaceId) {
        Query query = Query.select().where("SPACE_ID = ?", spaceId).order("ID DESC");
        return Arrays.asList(entityManager.find(SpaceTemplate.class, query));
    }

    @Override
    public SpaceTemplate addSpaceTemplate(SpaceTemplateDto dto) {
        final SpaceTemplate template = entityManager.create(SpaceTemplate.class,
                new DBParam("NAME", dto.getName()),
                new DBParam("DESCR", dto.getDescription()),
                new DBParam("BODY", dto.getBody()),
                new DBParam("CREATOR", dto.getCreator()),
                new DBParam("STATUS", StatusModel.NEW.toString()),
                new DBParam("SPACE_ID", dto.getSpaceId())
        );
        template.save();
        dto.getTags().forEach(
                tag -> tagDao.associateTagToTemplate(tagDao.getOrCreateTag(tag), template)
        );
        return getSpaceTemplate(template.getID());
    }

    @Override
    public SpaceTemplate updateSpaceTemplate(SpaceTemplateDto dto) {
        return entityManager.executeInTransaction( () -> {
            final SpaceTemplate template = getSpaceTemplate(dto.getId());
            template.setName(dto.getName());
            template.setBody(dto.getBody());
            template.setDescription(dto.getDescription());
            template.setCreator(dto.getCreator());
            template.setSpaceId(dto.getSpaceId());
            //remove existing associations
            templateDao.smartTagAssociationsRemove(template, dto.getTags());
            template.save();
            return getSpaceTemplate(template.getID());
        });
    }

    @Override
    public void deleteTemplate(SpaceTemplate template) {
        templateDao.deleteTemplate(template);
    }
}
