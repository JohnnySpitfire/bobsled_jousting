package org.beansinc.bobsled_jousting;

import java.util.NoSuchElementException;

public class BSExceptions {

    public static class ContestantNotFound extends NoSuchElementException {

        public ContestantNotFound(Contestant contestant, String teamName) {
            super(String.format("Contestant \"%s\" does not exist within team \"%s\"", contestant.getName(), teamName));
        }
    }

    public static class ObjectEffectNotFound extends NoSuchElementException {

        public <T> ObjectEffectNotFound(T effect){
            super(String.format("Effect \"%s\" not bound to contestant", effect));
        }
    }

    public static class InvalidObjectStatType extends Exception {

        public <T> InvalidObjectStatType(T effect, T name) {
            super(String.format("Effect \"%s\" (%s) or contestant \"%s\" (%s) is not a valid data type for contestantStats", 
                                        effect, effect.getClass(), name, name.getClass()));
        }
    }

    public static class InvalidTeamSize extends Exception {

        public InvalidTeamSize() {
            super("Team must contain between 4 and 10 contestants and no more than 5 reserves");
        }
    }
}
