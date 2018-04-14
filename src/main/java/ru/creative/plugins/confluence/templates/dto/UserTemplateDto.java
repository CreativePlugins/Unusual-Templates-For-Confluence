package ru.creative.plugins.confluence.templates.dto;

import ru.creative.plugins.confluence.templates.model.Tag;

import java.util.Set;

public class UserTemplateDto {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private String body;
    private String creator;
    private Set<Tag> tags;
    private Set<String> hotKeys;

    public UserTemplateDto() {
        //Jersey support
    }

    public UserTemplateDto(Integer id, String name, String description, String type, String body, String creator, Set<Tag> tags, Set<String> hotKeys) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.body = body;
        this.creator = creator;
        this.tags = tags;
        this.hotKeys = hotKeys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<String> getHotKeys() {
        return hotKeys;
    }

    public void setHotKeys(Set<String> hotKeys) {
        this.hotKeys = hotKeys;
    }
}
