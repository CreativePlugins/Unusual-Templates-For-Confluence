package ru.creative.plugins.confluence.templates.dao;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import net.java.ao.DBParam;
import net.java.ao.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.Template;

import java.util.Set;

public class TemplatesDaoImpl implements TemplatesDao {
    private static final Logger log = LoggerFactory.getLogger(TemplatesDaoImpl.class);
    private final ActiveObjects ao;

    private static final String TEMPLATE_NAME_ACCESSOR = "NAME";
    private static final String TEMPLATE_DESCRIPTION_ACCESSOR = "DESCR";
    private static final String TEMPLATE_BODY_ACCESSOR = "BODY";
    private static final String TEMPLATE_TYPE_ACCESSOR = "TEMPLATE_TYPE";
    private static final String TEMPLATE_CREATOR_ACCESSOR = "CREATOR";

    public TemplatesDaoImpl(ActiveObjects ao) {
        this.ao = ao;
    }


    @Override
    public Template getTemplateById(Integer id) {
        Template result = ao.get(Template.class, id);
        return result;
    }

    @Override
    public Template[] getUserTemplates(String creator) {
        return ao.find(Template.class, Query.select().where("CREATOR = ?", creator));
    }

    @Override
    public void deleteTemplate(Template template) {
        ao.delete(template);
    }

    @Override
    public void deleteTemplateById(Integer id) {
        ao.delete(getTemplateById(id));
    }

    @Override
    public Template updateTemplate(Template template) {
        //ToDo
        return null;
    }

    @Override
    public Template createOrUpdateTemplate(Template template, String name, String description, String type, String body, String templateType, String creator, Set<Tag> tags) {
        return ao.executeInTransaction(() -> {
            Template result = template;
            if((template != null)) {
                result = ao.create(Template.class,
                        new DBParam(TEMPLATE_NAME_ACCESSOR, name),
                        new DBParam(TEMPLATE_DESCRIPTION_ACCESSOR, description),
                        new DBParam(TEMPLATE_BODY_ACCESSOR, body),
                        new DBParam(TEMPLATE_TYPE_ACCESSOR, type),
                        new DBParam(TEMPLATE_CREATOR_ACCESSOR, creator));
            }
            result.setName(name);
            result.setDescription(description);
            result.setBody(body);
            result.setTemplateType(type);
            result.setCreator(creator);

            result.save();
            return result;
        });

    }
}
