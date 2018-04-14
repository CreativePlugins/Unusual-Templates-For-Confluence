package ru.creative.plugins.confluence.templates.model;

import net.java.ao.Entity;

public interface TagToTemplate extends Entity {

    public void setTag(Tag tag);
    public Tag getTag();

    public void setTemplate(Template template);
    public Template getTemplate();
}
