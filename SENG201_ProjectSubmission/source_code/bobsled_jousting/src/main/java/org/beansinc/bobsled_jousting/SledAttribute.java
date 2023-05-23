package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Stores sled attributes, and a method to generate random values.
 */
public enum SledAttribute {
    
    ARMOUR,
    SPEED;

    /**
     * Gets the default attributes.
     *
     * @return a 2D array of the default attributes containing {Attribute, Integer} pairs
     */
    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {ARMOUR, 100},
            {SPEED, 100},
        };
    }

    /**
     * Sled attributes list to generate random values from.
     */
    public static final List<SledAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets a random attribute.
     *
     * @param rn the rn
     * @return the random attribute
     */
    public static SledAttribute getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
