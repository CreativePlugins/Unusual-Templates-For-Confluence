package ru.creative.plugins.confluence.templates.model;

import net.java.ao.Accessor;
import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.Table;

@Preload
@Table("UC4C_Tag")
public interface Tag extends Entity {

    @NotNull
    @Accessor("NAME")
    String getName();
    void setName(String name);

    @ManyToMany(value = TagToTemplate.class)
    public Template[] getTemplates();

}
