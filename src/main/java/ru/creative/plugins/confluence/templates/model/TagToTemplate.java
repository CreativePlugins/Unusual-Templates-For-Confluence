package ru.creative.plugins.confluence.templates.model;

import net.java.ao.Entity;

public interface TagToTemplate extends Entity {
    AbstractTemplate getTeplate();
    void setTemplate(AbstractTemplate template);

    Tag getTag();
    void setTag(Tag tag);
}
