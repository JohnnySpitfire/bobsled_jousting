package org.beansinc.bobsled_jousting;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Customs exceptions used for the application.
 */
public class BSExceptions {

    /**
     * Throws if the contestant has not been found
     */
    public static class ContestantNotFound extends NoSuchElementException {

        /**
         * @param contestant the contestant not found
         * @param teamName the team name
         */
        public ContestantNotFound(Contestant contestant, String teamName) {
            super(String.format("Contestant \"%s\" does not exist within team \"%s\"", contestant.getName(), teamName));
        }
    }

    /**
     * Throws if the object modifier has not been found
     */
    public static class ObjectModifierNotFound extends NoSuchElementException {

        /**         *
         * @param <T> the generic type of object modifier
         * @param modifier the modifier not forund
         */
        public <T> ObjectModifierNotFound(T modifier){
            super(String.format("Effect \"%s\" not bound to contestant", modifier));
        }
    }

    /**
     * Throws if the attribute type is not valid for the member
     */
    public static class InvalidObjectAttributeType extends InvalidObjectException {

        /**         *
         * @param <T> the generic type
         * @param attributeClass the attribute class
         * @param name the name
         */
        public <T extends Class<?>> InvalidObjectAttributeType(T attributeClass, String name) {
            super(String.format("Attribute object \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeClass.getName(),
                                attributeClass,
                                name));
        }

        /**         *
         * @param <T> the generic type
         * @param attributeClass the attribute class
         * @param modifierClass the modifier class
         * @param name the name
         */
        public <T extends Class<?>> InvalidObjectAttributeType(T attributeClass, T modifierClass, String name) {
            super(String.format("Attribute object \"%s\" (%s) or Modifier \"%s\" (%s) is not a valid data type for member \"%s\"", 
                                attributeClass.getName(),
                                attributeClass,
                                modifierClass,
                                modifierClass.getName(),
                                name));
        }
    }

    /**
     * Throws if the team size is invalid
     */
    public static class InvalidTeamSize extends Exception {

        /**         *
         * @param team the team
         */
        public InvalidTeamSize(BaseTeam team) {
            super(String.format("Active team (%s contestants) cannot contain more than %s contestants and the reserve team (%s contestants) cannot contain more than %s contestants",
                                team.getActiveTeam().size(), BaseTeam.MAX_ACTIVE_SIZE,
                                team.getReserveTeam().size(), BaseTeam.MAX_RESERVE_SIZE));
        }
    }

    /**
     * Throws if an item has not been found in a list
    */
    public static class ItemNotFound extends Exception {
        
        /**         *
         * @param item the item
         * @param itemList the item list
         */
        public ItemNotFound(Item item, ArrayList<Item> itemList){
            super(String.format("%s not found in %s", item.name(), itemList));
        }
    }
}
