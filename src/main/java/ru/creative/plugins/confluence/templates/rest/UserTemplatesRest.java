package ru.creative.plugins.confluence.templates.rest;

import org.apache.commons.collections.map.SingletonMap;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.dto.UserTemplatesMetaDto;
import ru.creative.plugins.confluence.templates.model.Template;
import ru.creative.plugins.confluence.templates.service.UserTemplatesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserTemplatesRest {

    private final UserTemplatesService userTemplatesService;

    public UserTemplatesRest(UserTemplatesService userTemplatesService) {
        this.userTemplatesService = userTemplatesService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUserTemplates")
    public Response getUserTemplates(UserTemplatesMetaDto userTemplatesMetaDto) {

        return Response.ok(new SingletonMap("getUserTemplates", userTemplatesMetaDto)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveUserTemplates")
    public Response saveUserTemplate(UserTemplateDto userTemplateDto) {
        Template template = userTemplatesService.saveUserTemplate(userTemplateDto);
        return Response.ok(template).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPing")
    public Response getUserTemplates() {
        return Response.ok().build();
    }
}
