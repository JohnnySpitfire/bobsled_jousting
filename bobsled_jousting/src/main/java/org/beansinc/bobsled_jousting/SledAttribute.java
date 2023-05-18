package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum SledAttribute {
    
    ARMOUR,
    SPEED,
    SEATS;

    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {ARMOUR, 100},
            {SPEED, 100},
            {SEATS, 5}
        };
    }

    public static final List<SledAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static SledAttribute getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
