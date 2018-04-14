package ru.creative.plugins.confluence.templates.dao;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import net.java.ao.DBParam;
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
    public Template getTemplateById(Integer id, String creator) {
        //ToDo
        Template result = ao.get(Template.class, id);
        return result;
    }

    @Override
    public void deleteTemplate(Template template) {
        //ToDo
    }

    @Override
    public Template updateTemplate(Template template) {
        //ToDo
        return null;
    }

    @Override
    public Template createTemplate(String name, String description, String type, String body, String templateType, String creator, Set<Tag> tags) {
        return ao.executeInTransaction(() -> {
            final Template statistics = ao.create(Template.class,
                    new DBParam(TEMPLATE_NAME_ACCESSOR, name),
                    new DBParam(TEMPLATE_DESCRIPTION_ACCESSOR, description),
                    new DBParam(TEMPLATE_BODY_ACCESSOR, body),
                    new DBParam(TEMPLATE_TYPE_ACCESSOR, type),
                    new DBParam(TEMPLATE_CREATOR_ACCESSOR, creator));

            statistics.save();
            return statistics;
        });

    }
}
