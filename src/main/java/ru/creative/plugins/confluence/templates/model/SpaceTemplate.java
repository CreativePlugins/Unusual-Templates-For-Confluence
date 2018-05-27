package ru.creative.plugins.confluence.templates.model;

import net.java.ao.Accessor;
import net.java.ao.Preload;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.Table;

@Preload
@Table("UCFC_SpaceTemplate")
public interface SpaceTemplate extends AbstractTemplate {
    @NotNull
    @Accessor("SPACE_ID")
    Long getSpaceId();
    void setSpaceId(Long name);
}
