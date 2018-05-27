package ru.creative.plugins.confluence.templates.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.creative.plugins.confluence.templates.model.Tag;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractTemplateDto {
    public Integer id;
    public String name;
    public String description;
    public String body;
    public String creator;
    public String status;
    public Set<String> tags;

    AbstractTemplateDto(Integer id, String name, String description, String body, String creator, String status, Tag[] tags){
        this.id = id;
        this.name = name;
        this.description = description;
        this.body = body;
        this.creator = creator;
        this.status = status;
        this.tags = Arrays.stream(tags).map(Tag::getName).collect(Collectors.toSet());
    }


}
