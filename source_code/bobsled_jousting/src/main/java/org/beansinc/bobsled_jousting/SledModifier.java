package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Modifiers for the Sled, and a method to generate random values
 */
public enum SledModifier {

    HEAVY_ARMOUR(30),
    SLIME(5),
    SPIKES(15);

    /** The value of the sled. */
    public final int value;

    /**
     * Instantiates a new sled modifier.
     *
     * @param value the value of the sled
     */
    SledModifier(int value){
        this.value = value;
    }

    /**
     *  A list of sled modifiers used to generate a random value 
     */
    public static final List<SledModifier> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets a random attribute.
     *
     * @param rn the random object from GameEnviroment 
     * @return the random attribute
     */
    public static SledModifier getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
