package ru.creative.plugins.confluence.templates.service;

import ru.creative.plugins.confluence.templates.dao.SpaceTemplateDao;
import ru.creative.plugins.confluence.templates.dto.SpaceTemplateDto;

import java.util.List;
import java.util.stream.Collectors;

public class SpaceTemplatesService {
    private final SpaceTemplateDao spaceTemplateDao;

    public SpaceTemplatesService(SpaceTemplateDao spaceTemplateDao) {
        this.spaceTemplateDao = spaceTemplateDao;
    }

    public SpaceTemplateDto addSpaceTemplate(SpaceTemplateDto dto) {
        return new SpaceTemplateDto(spaceTemplateDao.addSpaceTemplate(dto));
    }

    public SpaceTemplateDto updateSpaceTemplate(SpaceTemplateDto dto) {
        return new SpaceTemplateDto(spaceTemplateDao.updateSpaceTemplate(dto));
    }

    public List<SpaceTemplateDto> getSpaceTemplatesBySpaceId(Long id) {
        return spaceTemplateDao.getSpaceTemplates(id).stream()
                .map(SpaceTemplateDto::new).collect(Collectors.toList());
    }
}
