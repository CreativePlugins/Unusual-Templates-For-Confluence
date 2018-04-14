package ru.creative.plugins.confluence.templates.dto;

public class UserTemplatesMetaDto {
    private String spaceId;
    private String userId;

    public UserTemplatesMetaDto() {
        //Jersey support
    }

    public UserTemplatesMetaDto(String spaceId, String userId) {
        this.spaceId = spaceId;
        this.userId = userId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
