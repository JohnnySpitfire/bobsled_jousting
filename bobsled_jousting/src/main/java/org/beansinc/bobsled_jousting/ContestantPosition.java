package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ContestantPosition {
    FORWARD,
    CENTRE,
    BACK,
    RESERVE;

    public static final List<ContestantPosition> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static ContestantPosition getRandomModifer(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
    
}
