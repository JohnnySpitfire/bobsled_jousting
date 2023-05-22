package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Enum ContestantModifer.
 */
public enum ContestantModifer {

    /** The sleepy. */
    SLEEPY(-10),
    
    /** The poisoned. */
    POISONED(-30),
    
    /** The paralysed. */
    PARALYSED(-20),
    
    /** The injured. */
    INJURED(-15);

    /** The value. */
    public final int value;

    /**
     * Instantiates a new contestant modifer.
     *
     * @param value the value
     */
    ContestantModifer(int value){
        this.value = value;
    }

    /** The Constant VALUES. */
    public static final List<ContestantModifer> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets the random modifer.
     *
     * @param rn the rn
     * @return the random modifer
     */
    public static ContestantModifer getRandomModifer(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
