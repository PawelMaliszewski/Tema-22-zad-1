package com.example.temat22zad1;

public enum Options {
    SERVICE_PROVIDED("Usługi", "service"),
    OPENING_HOURS("Godziny otwarcia", "opening-hours"),
    CONTACT_FORM("Kontakt", "contact");

    private final String description;
    private final String link;

    Options(String description, String link) {
        this.description = description;
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

}
