package ru.creative.plugins.confluence.templates.model;

import net.java.ao.Accessor;
import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.StringLength;
import net.java.ao.schema.Table;


@Preload
@Table("UC4C_Template")
public interface Template extends Entity {

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

    @ManyToMany(value = TagToTemplate.class)
    Tag[] getTags();

    @NotNull
    @Accessor("TEMPLATE_TYPE")
    String getTemplateType();
    void setTemplateType(String type);


    @NotNull
    @Accessor("CREATOR")
    String getCreator();
    void setCreator(String creator);

}
