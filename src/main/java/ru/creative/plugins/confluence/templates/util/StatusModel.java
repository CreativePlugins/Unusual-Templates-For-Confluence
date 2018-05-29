package ru.creative.plugins.confluence.templates.util;

public enum StatusModel {
    NEW("NEW"), DRAFT("DRAFT"), ACTIVE("ACTIVE"), DISABLED("DISABLED"), REMOVED("REMOVED");

    private final String status;

    /**
     * @param status
     */
    StatusModel(final String status) {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return status;
    }

}
