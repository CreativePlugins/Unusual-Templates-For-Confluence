package ru.creative.plugins.confluence.templates.dto;

import lombok.Data;
import ru.creative.plugins.confluence.templates.model.Tag;

import java.util.Set;

@Data
public class UserTemplateDto {
    public Integer id;
    public String name;
    public String description;
    public String type;
    public String body;
    public String creator;
    public Set<Tag> tags;
    public Set<String> hotKeys;
}
