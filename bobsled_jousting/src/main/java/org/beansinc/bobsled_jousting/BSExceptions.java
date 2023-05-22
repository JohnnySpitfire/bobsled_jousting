package org.beansinc.bobsled_jousting;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * The Class BSExceptions.
 */
public class BSExceptions {

    /**
     * The Class ContestantNotFound.
     */
    public static class ContestantNotFound extends NoSuchElementException {

        /**
         * Instantiates a new contestant not found.
         *
         * @param contestant the contestant
         * @param teamName the team name
         */
        public ContestantNotFound(Contestant contestant, String teamName) {
            super(String.format("Contestant \"%s\" does not exist within team \"%s\"", contestant.getName(), teamName));
        }
    }

    /**
     * The Class ObjectEffectNotFound.
     */
    public static class ObjectEffectNotFound extends NoSuchElementException {

        /**
         * Instantiates a new object effect not found.
         *
         * @param <T> the generic type
         * @param effect the effect
         */
        public <T> ObjectEffectNotFound(T effect){
            super(String.format("Effect \"%s\" not bound to contestant", effect));
        }
    }

    /**
     * The Class InvalidObjectAttributeType.
     */
    public static class InvalidObjectAttributeType extends InvalidObjectException {

        /**
         * Instantiates a new invalid object attribute type.
         *
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

        /**
         * Instantiates a new invalid object attribute type.
         *
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
     * The Class InvalidTeamSize.
     */
    public static class InvalidTeamSize extends Exception {

        /**
         * Instantiates a new invalid team size.
         *
         * @param team the team
         */
        public InvalidTeamSize(BaseTeam team) {
            super(String.format("Active team (%s contestants) cannot contain more than %s contestants and the reserve team (%s contestants) cannot contain more than %s contestants",
                                team.getActiveTeam().size(), BaseTeam.MAX_ACTIVE_SIZE,
                                team.getReserveTeam().size(), BaseTeam.MAX_RESERVE_SIZE));
        }
    }

    /**
     * The Class ItemNotFound.
     */
    public static class ItemNotFound extends Exception {
        
        /**
         * Instantiates a new item not found.
         *
         * @param item the item
         * @param itemList the item list
         */
        public ItemNotFound(Item item, ArrayList<Item> itemList){
            super(String.format("%s not found in %s", item.name(), itemList));
        }
    }
}
