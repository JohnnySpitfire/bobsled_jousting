package org.beansinc.bobsled_jousting;

import java.io.InvalidObjectException;
import java.util.ArrayList;
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

        public <T extends Class<?>> InvalidObjectAttributeType(T attributeClass, String name) {
            super(String.format("Attribute object \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeClass.getName(),
                                attributeClass,
                                name));
        }

        public <T extends Class<?>> InvalidObjectAttributeType(T attributeClass, T modifierClass, String name) {
            super(String.format("Attribute object \"%s\" (%s) or Modifier \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeClass.getName(),
                                attributeClass,
                                modifierClass,
                                modifierClass.getName(),
                                name));
        }
    }

    public static class InvalidTeamSize extends Exception {

        public InvalidTeamSize(BaseTeam team) {
            super(String.format("Active team (%s contestants) cannot contain more than %s contestants and the reserve team (%s contestants) cannot contain more than %s contestants",
                                team.getActiveTeam().size(), BaseTeam.MAX_ACTIVE_SIZE,
                                team.getReserveTeam().size(), BaseTeam.MAX_RESERVE_SIZE));
        }
    }

    public static class ItemNotFound extends Exception {
        
        public ItemNotFound(Item item, ArrayList<Item> itemList){
            super(String.format("%s not found in %s", item.name(), itemList));
        }
    }
}
