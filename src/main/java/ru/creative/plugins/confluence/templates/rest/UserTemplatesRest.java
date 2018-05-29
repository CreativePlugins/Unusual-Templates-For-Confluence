package ru.creative.plugins.confluence.templates.rest;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import lombok.extern.slf4j.Slf4j;
import ru.creative.plugins.confluence.templates.dto.UserTemplateDto;
import ru.creative.plugins.confluence.templates.service.UserTemplatesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Path("/user")
public class UserTemplatesRest {

    private final UserTemplatesService userTemplatesService;

    public UserTemplatesRest(UserTemplatesService userTemplatesService) {
        this.userTemplatesService = userTemplatesService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTemplates")
    public Response getUserTemplates() {
        ConfluenceUser user = AuthenticatedUserThreadLocal.get();
        List<UserTemplateDto> userTemplate = userTemplatesService.getUserTemplates(user.getName());
        return Response.ok(userTemplate).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addTemplate")
    public Response addUserTemplate(UserTemplateDto userTemplateDto) {
        UserTemplateDto userTemplate;
        if(userTemplateDto.getId() != null){
            userTemplate = userTemplatesService.updateUserTemplate(userTemplateDto);
        }else {
            userTemplate = userTemplatesService.addUserTemplate(userTemplateDto);
        }
        return Response.ok(userTemplate).build();
    }
}
