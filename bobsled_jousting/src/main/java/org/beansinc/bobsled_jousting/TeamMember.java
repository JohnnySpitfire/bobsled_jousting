package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamMember.
 *
 * @param <A> the generic type
 * @param <M> the generic type
 */
@SuppressWarnings("unchecked")
public class TeamMember<A extends Enum<A>, M extends Enum<M>> {
    
    /** The name. */
    private String name;
    
    /** The object attributes. */
    private EnumMap<A, Integer> objectAttributes;
    
    /** The object modifiers. */
    private EnumSet<M> objectModifiers;
    
    /** The value. */
    private int value;

    /**
     * Instantiates a new team member.
     *
     * @param name the name
     * @param attributesClass the attributes class
     * @param modifiersClass the modifiers class
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public TeamMember(String name, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        this.setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
    }

    /**
     * Instantiates a new team member.
     *
     * @param name the name
     * @param attributes the attributes
     * @param attributesClass the attributes class
     * @param modifiersClass the modifiers class
     * @throws InvalidObjectAttributeType the invalid object attribute type
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
     * @param name the name
     * @param attributes the attributes
     * @param modifiers the modifiers
     * @param value the value
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
     * @return int
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the value.
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
     * Gets the attribute.
     *
     * @param stat the stat
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
     * Adds the attribute.
     *
     * @param stat the stat
     * @param value the value
     */
    public void addAttribute(A stat, int value){

        this.objectAttributes.put(stat, value);
    }

    /**
     * Removes the attribute.
     *
     * @param attr the attr
     */
    public void removeAttribute(A attr) {

        this.objectAttributes.remove(attr);
    }

    /**
     * Adds the modifier.
     *
     * @param effect the effect
     */
    public void addModifier(M effect) {

        this.objectModifiers.add(effect);
    }

    /**
     * Edits the attribute.
     *
     * @param stat the stat
     * @param newVal the new val
     */
    public void editAttribute(A stat, int newVal) {
        this.objectAttributes.replace(stat, newVal);
    }

    /**
     * Removes the modifier.
     *
     * @param effect the effect
     * @throws ObjectEffectNotFound the object effect not found
     */
    public void removeModifier(M effect) throws ObjectEffectNotFound {

        if(!this.objectModifiers.contains(effect)) {
            throw new ObjectEffectNotFound(effect);
        } else {
            this.objectModifiers.remove(effect);
        }
    }
 
    /**
     * Generate default stats map.
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
     * Sets the object enum map and enum set.
     *
     * @param attributes the attributes
     * @param modifiers the modifiers
     * @throws InvalidObjectAttributeType the invalid object attribute type
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
     * Populate object attributes with input.
     *
     * @param stats the stats
     * @throws InvalidObjectAttributeType the invalid object attribute type
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
