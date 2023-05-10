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

    public TeamMember(String name, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
    }

    public TeamMember(String name, Object[][] attributes, Class<A> attributesClass, Class<M> modifiersClass) throws InvalidObjectAttributeType {

        this.name = name;
        setObjectEnumMapAndEnumSet(attributesClass, modifiersClass);
        
        this.objectAttributes = this.generateDefaultStatsMap(attributesClass);
        populateObjectAttributesWithInput(attributes);
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Map<A, Integer> getAttributes(){

        return this.objectAttributes;
    }

    public int getAttributes(A stat) {
        return this.objectAttributes.get(stat);
    }

    public EnumSet<M> getModifiers(){
        
        return this.objectModifiers;
    }

    public void AddStat(A stat, int value){

        this.objectAttributes.put(stat, value);
    }

    public void RemoveStat(A stat) {

        this.objectAttributes.remove(stat);
    }

    public void AddEffect(M effect) {

        this.objectModifiers.add(effect);
    }

    public void EditStat(A stat, int newVal) {
        this.objectAttributes.replace(stat, newVal);
    }

    public void RemoveEffect(M effect) throws ObjectEffectNotFound {

        if(!this.objectModifiers.contains(effect)) {
            throw new ObjectEffectNotFound(effect);
        } else {
            this.objectModifiers.remove(effect);
        }
    }
 
    private EnumMap<A, Integer> generateDefaultStatsMap(Class<A> attributes){

        Object[][] defaultStatsArr = attributes == ContestantAttributes.class? 
                                    ContestantAttributes.getDefaultAttributes():
                                    SledAttributes.getDefaultAttributes();

        Map<?,?> defaultStatsMap = Utils.write2DArrayToMap(defaultStatsArr);

        //no need to check as they are constant
        EnumMap<A, Integer> defaultStats = new EnumMap<>(attributes);
        defaultStats.putAll((Map<? extends A, ? extends Integer>) defaultStatsMap);
        
        return defaultStats;
    }

    private void setObjectEnumMapAndEnumSet(Class<A> attributes, Class<M> modifiers) throws InvalidObjectAttributeType {
        if(attributes == ContestantAttributes.class && modifiers == ContestantModifers.class) {
            this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<ContestantAttributes, Integer>(ContestantAttributes.class);
            this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(ContestantModifers.class);

        } else if (attributes == SledAttributes.class && modifiers == SledModifiers.class) {
            this.objectAttributes = (EnumMap<A, Integer>) new EnumMap<SledAttributes, Integer>(SledAttributes.class);
            this.objectModifiers = (EnumSet<M>) EnumSet.noneOf(SledModifiers.class);
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
