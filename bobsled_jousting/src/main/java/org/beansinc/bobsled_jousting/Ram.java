package org.beansinc.bobsled_jousting;

public enum Ram {
    
    WOODEN_RAM("Wooden Ram", 5, 10, 1),
    STEEL_RAM("Steel Ram", 10, 20, 10);

    public final String name;
    public final int damage;
    public final int health;
    public final int resistance;

    private Ram(String name, int damage, int health, int resistance) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.resistance = resistance;
    }
}
