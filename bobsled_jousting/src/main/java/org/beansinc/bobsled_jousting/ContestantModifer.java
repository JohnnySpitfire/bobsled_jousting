package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ContestantModifer {
    SLEEPY,
    POISONED,
    PARALYSED,
    DRUNK,
    TIPSY;

    public static final List<ContestantModifer> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static ContestantModifer getRandomModifer(Random rn) {
         
        return VALUES.get(rn.nextInt(VALUES.size()));
    }
}
