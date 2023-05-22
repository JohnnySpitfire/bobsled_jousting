package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ContestantAttribute {
    OFFENCE,
    DEFENCE,
    MAX_STANIMA,
    STANIMA;

    public static final List<ContestantAttribute> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static ContestantAttribute getRandomAttribute(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }

    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {OFFENCE, 100},
            {DEFENCE, 100},
            {MAX_STANIMA, 100},
            {STANIMA, 100}
        };
    }
}
