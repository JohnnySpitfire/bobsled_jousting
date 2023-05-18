package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum SledModifier {

    HEAVY_ARMOUR(30),
    SLIME(5),
    SPIKES(15);

    public final int value;

    SledModifier(int value){
        this.value = value;
    }

    public static final List<SledModifier> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static SledModifier getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
