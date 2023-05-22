package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Enum SledAttribute.
 */
public enum SledAttribute {
    
    /** The armour. */
    ARMOUR,
    
    /** The speed. */
    SPEED;

    /**
     * Gets the default attributes.
     *
     * @return the default attributes
     */
    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {ARMOUR, 100},
            {SPEED, 100},
        };
    }

    /** The Constant VALUES. */
    public static final List<SledAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    /**
     * Gets the random attribute.
     *
     * @param rn the rn
     * @return the random attribute
     */
    public static SledAttribute getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
