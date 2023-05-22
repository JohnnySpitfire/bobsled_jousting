package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Enum SledModifier.
 */
public enum SledModifier {

    /** The heavy armour. */
    HEAVY_ARMOUR(30),
    
    /** The slime. */
    SLIME(5),
    
    /** The spikes. */
    SPIKES(15);

    /** The value. */
    public final int value;

    /**
     * Instantiates a new sled modifier.
     *
     * @param value the value
     */
    SledModifier(int value){
        this.value = value;
    }

    /** The Constant VALUES. */
    public static final List<SledModifier> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets the random attribute.
     *
     * @param rn the rn
     * @return the random attribute
     */
    public static SledModifier getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
