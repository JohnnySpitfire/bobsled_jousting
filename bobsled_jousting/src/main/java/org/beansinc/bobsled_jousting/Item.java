package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Item {
    
    HEALTH_POTION(50);

    public final int value;

    Item(int value){
        this.value = value;
    }

    public static final List<Item> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static Item getRandomItem(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }
}
