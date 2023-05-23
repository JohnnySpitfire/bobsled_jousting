package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Attributes for the Contestant, and a method to generate random values
 */
public enum ContestantAttribute {
    
    OFFENCE,
    DEFENCE,
    MAX_STANIMA,
    STANIMA;

    /** A list of attributes to generate a random modifier. */
    public static final List<ContestantAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets a random attribute.
     *
     * @param rnd the rnd object from GameObject
     * @return the random attribute
     */
    public static ContestantAttribute getRandomAttribute(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }

    /**
     * Gets the default attributes.
     *
     * @return the default attributes as a 2D array with {Attribute, Integer} pairs
     */
    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {OFFENCE, 100},
            {DEFENCE, 100},
            {MAX_STANIMA, 100},
            {STANIMA, 100}
        };
    }
}
