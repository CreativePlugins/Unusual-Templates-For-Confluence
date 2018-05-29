package ru.creative.plugins.confluence.templates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

@Data
@AllArgsConstructor
public class UserTemplateDto extends AbstractTemplateDto{
    @Builder
    public UserTemplateDto(UserTemplate ut){
        super(ut.getID(), ut.getName(), ut.getDescription(), ut.getBody(), ut.getCreator(), ut.getStatus(), ut.getTags());
    }

}
