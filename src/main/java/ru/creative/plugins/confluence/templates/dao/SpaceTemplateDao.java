package ru.creative.plugins.confluence.templates.dao;

import ru.creative.plugins.confluence.templates.dto.SpaceTemplateDto;
import ru.creative.plugins.confluence.templates.model.SpaceTemplate;

import java.util.List;

public interface SpaceTemplateDao {

    SpaceTemplate getSpaceTemplate(Integer id);

    List<SpaceTemplate> getSpaceTemplates(Long spaceId);

    SpaceTemplate addSpaceTemplate(SpaceTemplateDto template);

    SpaceTemplate updateSpaceTemplate(SpaceTemplateDto dto);

    void deleteTemplate(SpaceTemplate template);
}

