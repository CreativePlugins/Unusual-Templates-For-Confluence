package ru.creative.plugins.confluence.templates.model;

import net.java.ao.*;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.StringLength;
import net.java.ao.schema.Table;

@Polymorphic
@Table("UC4C_AbstractTemplate")
public interface AbstractTemplate extends Entity {

    @NotNull
    @Accessor("NAME")
    String getName();
    void setName(String name);

    @NotNull
    @Accessor("DESCR")
    String getDescription();
    void setDescription(String description);

    @NotNull
    @Accessor("BODY")
    @StringLength(StringLength.UNLIMITED)
    String getBody();
    void setBody(String body);

    @NotNull
    @Accessor("CREATOR")
    String getCreator();
    void setCreator(String creator);

    @ManyToMany(value = TagToTemplate.class)
    Tag[] getTags();
}