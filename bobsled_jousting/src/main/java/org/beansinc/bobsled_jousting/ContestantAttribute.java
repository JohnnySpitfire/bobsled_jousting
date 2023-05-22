package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Enum ContestantAttribute.
 */
public enum ContestantAttribute {
    
    /** The offence. */
    OFFENCE,
    
    /** The defence. */
    DEFENCE,
    
    /** The max stanima. */
    MAX_STANIMA,
    
    /** The stanima. */
    STANIMA;

    /** The Constant VALUES. */
    public static final List<ContestantAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets the random attribute.
     *
     * @param rn the rn
     * @return the random attribute
     */
    public static ContestantAttribute getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }

    /**
     * Gets the default attributes.
     *
     * @return the default attributes
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
