package ru.creative.plugins.confluence.templates.model;

import net.java.ao.*;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.Table;
import net.java.ao.schema.Unique;

@Preload
@Table("UC4C_Tags")
public interface Tag extends Entity {
    @Unique
    @NotNull
    @Accessor("NAME")
    String getName();
    void setName(String name);

    @ManyToMany(value = TagToTemplate.class)
    AbstractTemplate[] getTemplates();
}
