package org.beansinc.bobsled_jousting;

import java.io.InvalidObjectException;
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

    public static class InvalidObjectAttributeType extends InvalidObjectException {

        public <T extends Class<?>> InvalidObjectAttributeType(T attributeObj, String name) {
            super(String.format("Attribute object \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeObj.getName(),
                                attributeObj,
                                name));
        }

        public <T extends Class<?>> InvalidObjectAttributeType(T attributeObj, T modifierObj, String name) {
            super(String.format("Attribute object \"%s\" (%s) or Modifier \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeObj.getName(),
                                attributeObj,
                                modifierObj,
                                modifierObj.getName(),
                                name));
        }
    }

    public static class InvalidTeamSize extends Exception {

        public InvalidTeamSize() {
            super("Team must contain between 4 and 10 contestants and no more than 5 reserves");
        }
    }
}
