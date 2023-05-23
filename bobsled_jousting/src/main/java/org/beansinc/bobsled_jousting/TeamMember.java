package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectModifierNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

/**
 * Provides the basic functionality for all team members (Sleds and Contestants).
 * Has generic types so different attributes and modifiers can be given to a team member
 * 
 * @param <A> the generic type of attributes (Must be an enummerator)
 * @param <M> the generic type of modifiers (Must be an enummerator)
 */
@SuppressWarnings("unchecked")
public class TeamMember<A extends Enum<A>, M extends Enum<M>> {
    
    /** The Team Members name. */
    private String name;
    
    /** The object attributes, A map of the generic attribute type and an integer. */
    private EnumMap<A, Integer> objectAttributes;
    
    /** The object modifiers, A set of the generic modifier type. */
    private EnumSet<M> objectModifiers;
    
    /** The value. */
    private int value;

    /**
     * Instantiates a new team member.
     *
     * @param name the team member's name
     * @param attributesClass the generic attribute type class
     * @param modifiersClass the generic modifier type class
     * @throws InvalidObjectAttributeType Throws if the generic type is invaild (not sled or contestant attributes)
     */
    public TeamMember(String name, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        this.setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
    }

    /**
     * Instantiates a new team member.
     *
     * @param name the team member's name
     * @param attributes custom attributes to be instaniated in the class, must be a 2D array of {AttributeType, Integer}
     * @param attributesClass the generic attribute type class
     * @param modifiersClass the generic modifier type class
     * @throws InvalidObjectAttributeType Throws if the generic type is invaild (not sled or contestant attributes)
     */
    public TeamMember(String name, Object[][] attributes, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        this.setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
        this.populateObjectAttributesWithInput(attributes);

    }

    /**
     * Instantiates a new team member.
     *
     * @param name the team member's name
     * @param attributes custom attributes to be instantiated, this one is already in a map, and does not need to be converted
     * @param modifiers custom modifiers to be instantiated, this one is already in a set, and does not need to be converted
     * @param value the funds value of the team member
     */
    public TeamMember(String name, Map<ContestantAttribute, Integer> attributes, EnumSet<ContestantModifer> modifiers, int value) {

        this.name = name;

        this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<ContestantAttribute, Integer>(ContestantAttribute.class);
        this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(ContestantModifer.class);

        for(ContestantAttribute attr: attributes.keySet()) {
            this.objectAttributes.put((A) attr, attributes.get(attr));
        }

        this.value = value;

    }

    
    /** 
     * @return String
     */
    public String getName() {

        return this.name;
    }

    
    /**
     *  
     *
     * @param name the new name
     */
    public void setName(String name) {

        this.name = name;
    }

    
    /**
     * Returns the funds value of the team member 
     * 
     * @return int
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the funds value.
     *
     * @param val the new value
     */
    public void setValue(int val){
        this.value = val;
    }

    /**
     * Gets the attributes.
     *
     * @return the attributes
     */
    public Map<A, Integer> getAttributes(){

        return this.objectAttributes;
    }

    /**
     * Gets an attribute value.
     *
     * @param stat the attribute to check
     * @return the attribute
     */
    public int getAttribute(A stat) {
        return this.objectAttributes.get(stat);
    }

    /**
     * Gets the modifiers.
     *
     * @return the modifiers
     */
    public EnumSet<M> getModifiers(){
        
        return this.objectModifiers;
    }

    /**
     * Adds an attribute.
     *
     * @param stat the attribute to add
     * @param value the value of the attribute
     */
    public void addAttribute(A stat, int value){

        this.objectAttributes.put(stat, value);
    }

    /**
     * Removes an attribute.
     *
     * @param attr the attribute to be removed
     */
    public void removeAttribute(A attr) {

        this.objectAttributes.remove(attr);
    }

    /**
     * Adds a modifier.
     *
     * @param effect the effect
     */
    public void addModifier(M effect) {

        this.objectModifiers.add(effect);
    }

    /**
     * Edits an attribute.
     *
     * @param stat the attribute to be modified
     * @param newVal the new value
     */
    public void editAttribute(A stat, int newVal) {
        this.objectAttributes.replace(stat, newVal);
    }

    /**
     * Removes a modifier.
     *
     * @param modifier the modifier to be removed
     * @throws ObjectModifierNotFound throws if the specified modifier was not found
     */
    public void removeModifier(M modifier) throws ObjectModifierNotFound {

        if(!this.objectModifiers.contains(modifier)) {
            throw new ObjectModifierNotFound(modifier);
        } else {
            this.objectModifiers.remove(modifier);
        }
    }
 
    /**
     * Generate the default stats map.
     * This gets the default attribute values from the attributes class, and converts it into a Map
     *
     * @param attributes the attributes
     * @return the enum map
     */
    private EnumMap<A, Integer> generateDefaultStatsMap(Class<A> attributes){

        Object[][] defaultStatsArr = attributes == ContestantAttribute.class? 
                                    ContestantAttribute.getDefaultAttributes():
                                    SledAttribute.getDefaultAttributes();

        Map<?,?> defaultStatsMap = Utils.write2DArrayToMap(defaultStatsArr);

        //no need to check as they are constant
        EnumMap<A, Integer> defaultStats = new EnumMap<>(attributes);
        defaultStats.putAll((Map<? extends A, ? extends Integer>) defaultStatsMap);
        
        return defaultStats;
    }

    /**
     * Sets the types of the Attribute map and Modifier set (either Sled or Contestant attributes and modifiers)
     *
     * @param attributes the attributes class
     * @param modifiers the modifiers class
     * @throws InvalidObjectAttributeType throws if the classes are not valid (not Sled or Contestant attributes and modifiers)
     */
    private void setObjectEnumMapAndEnumSet(Class<A> attributes, Class<M> modifiers) throws InvalidObjectAttributeType {

        if(attributes == ContestantAttribute.class && modifiers == ContestantModifer.class) {

            this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<ContestantAttribute, Integer>(ContestantAttribute.class);
            this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(ContestantModifer.class);

        } else if (attributes == SledAttribute.class && modifiers == SledModifier.class) {

            this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<SledAttribute, Integer>(SledAttribute.class);
            this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(SledModifier.class);

        } else {
            
            throw new InvalidObjectAttributeType(attributes.getClass(), modifiers.getClass(), name);
        }
    }

    /**
     * Populates defined ObjectAttributes Map with input from a 2D Object array.
     *
     * @param stats the 2D attributes array containing {Attribute, Integer} pairs
     * @throws InvalidObjectAttributeType throws if the classes are not valid (not enumerators)
     */
    private void populateObjectAttributesWithInput(Object[][] stats) throws InvalidObjectAttributeType {
        for (Object[] stat : stats) {
            if(!(stat[0] instanceof Enum<?>) || !(stat[1] instanceof Integer)) {
                throw new InvalidObjectAttributeType(stat[0].getClass(), name);
            } else {
                this.objectAttributes.put((A) stat[0], (Integer) stat[1]);
            }
        }
    }
}
