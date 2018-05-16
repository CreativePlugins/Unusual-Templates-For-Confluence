package ru.creative.plugins.confluence.templates.rest;

import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.dto.UserTemplatesMetaDto;
import ru.creative.plugins.confluence.templates.model.UserTemplate;
import ru.creative.plugins.confluence.templates.service.UserTemplatesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, UserTemplatesMetaDto> result = new HashMap<>();
        result.put("getUserTemplates", userTemplatesMetaDto);
        return Response.ok(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveUserTemplates")
    public Response saveUserTemplate(UserTemplateDto userTemplateDto) {
        UserTemplate userTemplate = userTemplatesService.saveUserTemplate(userTemplateDto);
        return Response.ok(userTemplate).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPing")
    public Response getUserTemplates() {
        return Response.ok().build();
    }
}
