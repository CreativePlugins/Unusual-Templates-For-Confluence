package ru.creative.plugins.confluence.templates.dto;

import lombok.Builder;
import lombok.Data;
import ru.creative.plugins.confluence.templates.model.SpaceTemplate;


@Data
public class SpaceTemplateDto extends AbstractTemplateDto{
    //ToDo: create more smart DTO;
    public Long spaceId;

    @Builder
    public SpaceTemplateDto(SpaceTemplate st){
        super(st.getID(), st.getName(), st.getDescription(), st.getBody(), st.getCreator(), st.getStatus(), st.getTags());
        this.spaceId = st.getSpaceId();
    }
}



