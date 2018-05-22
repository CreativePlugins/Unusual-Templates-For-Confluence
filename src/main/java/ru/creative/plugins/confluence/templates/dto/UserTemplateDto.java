package ru.creative.plugins.confluence.templates.dto;

import com.atlassian.elasticsearch.shaded.lucene.search.Collector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.creative.plugins.confluence.templates.model.Tag;
import ru.creative.plugins.confluence.templates.model.UserTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTemplateDto {
    public Integer id;
    public String name;
    public String description;
    public String body;
    public String creator;
    public Set<String> tags;

    public static UserTemplateDto convert(UserTemplate ut){
        return UserTemplateDto.builder()
                .id(ut.getID())
                .name(ut.getName())
                .description(ut.getDescription())
                .body(ut.getBody())
                .creator(ut.getCreator())
                .tags(Arrays.stream(ut.getTags()).map(Tag::getName).collect(Collectors.toSet()))
                .build();

    }
}
