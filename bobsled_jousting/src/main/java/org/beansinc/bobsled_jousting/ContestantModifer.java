package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Modifiers for the Contestant, and a method to generate random values
 */
public enum ContestantModifer {

    SLEEPY(-10),
    POISONED(-30),
    PARALYSED(-20),
    INJURED(-15);

    /** The funds value of the modifier. */
    public final int value;

    /**
     * Instantiates a new contestant modifer.
     *
     * @param value the funds value of a modifier
     */
    ContestantModifer(int value){
        this.value = value;
    }

    /** A list of modifiers to generate a random modifier. */
    public static final List<ContestantModifer> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets a random modifer.
     *
     * @param rnd the rnd object from GameObject
     * @return the random modifer
     */
    public static ContestantModifer getRandomModifer(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }
}
