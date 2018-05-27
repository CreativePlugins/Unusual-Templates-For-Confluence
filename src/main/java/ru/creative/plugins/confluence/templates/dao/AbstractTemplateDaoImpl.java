package ru.creative.plugins.confluence.templates.dao;

import com.atlassian.activeobjects.external.ActiveObjects;
import lombok.extern.slf4j.Slf4j;
import net.java.ao.Query;
import ru.creative.plugins.confluence.templates.model.AbstractTemplate;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.util.StatusModel;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class AbstractTemplateDaoImpl implements AbstractTemplateDao {

    private final ActiveObjects entityManager;
    private final TagDao tagDao;

    public AbstractTemplateDaoImpl(ActiveObjects entityManager, TagDao tagDao) {
        this.entityManager = checkNotNull(entityManager);
        this.tagDao = checkNotNull(tagDao);
    }

    @Override
    public void deleteTemplate(AbstractTemplate template) {
        entityManager.executeInTransaction( () -> {
            template.setStatus(StatusModel.REMOVED.toString());
            template.save();
            return template;
        });
    }

    @Override
    public <T extends AbstractTemplate> T getTemplate(Integer id, Class<T> clazz) {
        final T[] templates = entityManager.find(clazz, Query.select().where("ID = ?", id));
        if (templates.length > 1){
            log.error("AbstractTemplate cannot have two instances with same ID");
        }
        return templates.length > 0 ? templates[0] : null;
    }

    @Override
    public void smartTagAssociationsRemove(AbstractTemplate template, Set<String> dtoTags){
        List<String> tags = Arrays.stream(template.getTags()).map(Tag::getName).collect(Collectors.toList());
        Arrays.stream(template.getTags()).filter(it -> !dtoTags.contains(it.getName())).forEach(
                it -> tagDao.removeTagToTemplateAssociation(it, template)
        );
        dtoTags.stream().filter(it -> !tags.contains(it)).forEach(
                it -> tagDao.associateTagToTemplate(tagDao.getOrCreateTag(it), template)
        );
    }
}
