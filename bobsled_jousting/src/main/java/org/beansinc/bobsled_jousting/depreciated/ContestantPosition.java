package org.beansinc.bobsled_jousting.depreciated;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ContestantPosition {
    FORWARD,
    CENTRE,
    BACK;

    public static final List<ContestantPosition> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static ContestantPosition getRandomPosition(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }
    
}
