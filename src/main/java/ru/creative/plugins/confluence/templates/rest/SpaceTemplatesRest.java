package ru.creative.plugins.confluence.templates.rest;


import lombok.extern.slf4j.Slf4j;
import ru.creative.plugins.confluence.templates.dto.SpaceTemplateDto;
import ru.creative.plugins.confluence.templates.service.SpaceTemplatesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Path("/space")
public class SpaceTemplatesRest {

    private final SpaceTemplatesService spaceTemplatesService;

    public SpaceTemplatesRest(SpaceTemplatesService spaceTemplatesService) {
        this.spaceTemplatesService = spaceTemplatesService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTemplates/{spaceId}")
    public Response getUserTemplates(@PathParam("spaceId") Long spaceId) {
        List<SpaceTemplateDto> templates = spaceTemplatesService.getSpaceTemplatesBySpaceId(spaceId);
        return Response.ok(templates).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addTemplate")
    public Response addUserTemplate(SpaceTemplateDto spaceTemplateDto) {
        //ToDo: inject creator into DTO;
        //ToDo: check space permissions;
        SpaceTemplateDto spaceTemplate;
        if(spaceTemplateDto.getId() != null){
            spaceTemplate = spaceTemplatesService.updateSpaceTemplate(spaceTemplateDto);
        }else {
            spaceTemplate = spaceTemplatesService.addSpaceTemplate(spaceTemplateDto);
        }
        return Response.ok(spaceTemplate).build();
    }
}
