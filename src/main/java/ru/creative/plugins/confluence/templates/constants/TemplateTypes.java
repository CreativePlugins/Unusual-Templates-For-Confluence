package ru.creative.plugins.confluence.templates.constants;

public enum TemplateTypes {
    USER("USER"),
    SPACE("SPACE"),
    GLOBAL("GLOBAL");

    private final String text;

    /**
     * @param text - template type string
     */
    TemplateTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}