package org.beansinc.bobsled_jousting;

public enum Ram {
    
    WOODEN_RAM("Wooden Ram", 5, 10, 1, 10),
    STEEL_RAM("Steel Ram", 10, 20, 10, 25);

    public final String name;
    public final int damage;
    public final int health;
    public final int resistance;
    public final int value;

    private Ram(String name, int damage, int health, int resistance, int value) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.resistance = resistance;
        this.value = value;
    }
}
