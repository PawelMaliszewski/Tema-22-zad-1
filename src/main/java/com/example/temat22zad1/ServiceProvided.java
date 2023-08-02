package com.example.temat22zad1;

public enum ServiceProvided {
    ENGINE_OIL_CHANGE("Wymiana oleju silnika", 250),
    GEARBOX_ENGINE_OIL_CHANGE("Wymiana oleju skrzyni biegów", 400),
    BRAKE_PADS_SERVICE("Wymian klocków hamulcowych", 200),
    BRAKE_DISCS_SERVICE("Wymian tarcz hamulcowych", 350),
    SUSPENSION_SERVICE("Naprawa zawieszenia", 450);

    private final String description;

    private double price;

    ServiceProvided(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
