package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

@SuppressWarnings("unchecked")
public class TeamMember<A extends Enum<A>, M extends Enum<M>> {
    
    private String name;
    private EnumMap<A, Integer> objectAttributes;
    private EnumSet<M> objectModifiers;
    private int value;

    public TeamMember(String name, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        this.setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
    }

    public TeamMember(String name, Object[][] attributes, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        this.setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
        this.populateObjectAttributesWithInput(attributes);

    }

    public TeamMember(String name, Map<ContestantAttribute, Integer> attributes, EnumSet<ContestantModifer> modifiers, int value) {

        this.name = name;

        this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<ContestantAttribute, Integer>(ContestantAttribute.class);
        this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(ContestantModifer.class);

        for(ContestantAttribute attr: attributes.keySet()) {
            this.objectAttributes.put((A) attr, attributes.get(attr));
        }

        this.value = value;

    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int val){
        this.value = val;
    }

    public Map<A, Integer> getAttributes(){

        return this.objectAttributes;
    }

    public int getAttribute(A stat) {
        return this.objectAttributes.get(stat);
    }

    public EnumSet<M> getModifiers(){
        
        return this.objectModifiers;
    }

    public void addAttribute(A stat, int value){

        this.objectAttributes.put(stat, value);
    }

    public void removeStat(A stat) {

        this.objectAttributes.remove(stat);
    }

    public void addModifier(M effect) {

        this.objectModifiers.add(effect);
    }

    public void editStat(A stat, int newVal) {
        this.objectAttributes.replace(stat, newVal);
    }

    public void removeEffect(M effect) throws ObjectEffectNotFound {

        if(!this.objectModifiers.contains(effect)) {
            throw new ObjectEffectNotFound(effect);
        } else {
            this.objectModifiers.remove(effect);
        }
    }
 
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
