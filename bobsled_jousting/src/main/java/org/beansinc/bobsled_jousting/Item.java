package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Item {
    
    ATTACK_POTION(50, "Temporarily increases a contestants offence by 20 for one match"),
    DEFENCE_POTION(50, "Temporarily increases a contestants defence by 20 for one match"),
    STANIMA_POTION(50, "Temporarily increases a contestants stamina by 20 for one match"),
    SLIME_BOMB(100, "Slimes an enemy sled decreasing their offence and stanima by 40");

    public final int value;
    public final String description;

    Item(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static final List<Item> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static Item getRandomItem(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }

    
}
