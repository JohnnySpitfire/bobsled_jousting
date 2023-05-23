package org.beansinc.bobsled_jousting.depreciated;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectModifierNotFound;
import org.beansinc.bobsled_jousting.ContestantAttribute;
import org.beansinc.bobsled_jousting.ContestantModifer;
import org.beansinc.bobsled_jousting.Utils;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

@SuppressWarnings("unchecked")
public class ContestantOld {
    
    private String contestantName;
    private ContestantPosition contestantPosition;
    private EnumMap<ContestantAttribute, Integer> contestantStats;
    private EnumSet<ContestantModifer> contestantEffects;

    public ContestantOld(String name){

        this.contestantName = name;
        this.contestantPosition = ContestantPosition.CENTRE;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifer.class);
    }

    public ContestantOld(String name, ContestantPosition position){
        
        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifer.class);

    }

    public ContestantOld(String name, ContestantPosition position, Object[][] stats) throws InvalidObjectAttributeType{

        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifer.class);

        for (Object[] stat : stats) {
            if(!(stat[0] instanceof ContestantAttribute) || !(stat[1] instanceof Integer)) {
                // throw new InvalidObjectAttributeType(stat[0], stat[1]);
            } else {
                this.contestantStats.put((ContestantAttribute) stat[0], (Integer) stat[1]);
            }
        }
    }

    
    /** 
     * @return String
     */
    public String getName(){

        return this.contestantName;
    }

    public ContestantPosition getPosition(){
        
        return this.contestantPosition;
    }

    public EnumMap<ContestantAttribute, Integer> getStats(){

        return this.contestantStats;
    }

    public EnumSet<ContestantModifer> getEffects(){
        
        return this.contestantEffects;
    }

    public void SetPosition(ContestantPosition position){
        
        this.contestantPosition = position;
    }

    public void AddStat(ContestantAttribute stat, int value){

        this.contestantStats.put(stat, value);
    }

    public void RemoveStat(ContestantAttribute stat) {

        this.contestantStats.remove(stat);
    }

    public void AddEffect(ContestantModifer effect) {

        this.contestantEffects.add(effect);
    }

    public void RemoveEffect(ContestantModifer effect) throws ObjectModifierNotFound {

        if(!this.contestantEffects.contains(effect)) {
            throw new ObjectModifierNotFound(effect);
        } else {
            this.contestantEffects.remove(effect);
        }
    }
 
    private EnumMap<ContestantAttribute, Integer> generateDefaultStatsMap(){

        Object[][] defaultStatsArr = ContestantAttribute.getDefaultAttributes();
        Map<?,?> defaultStatsMap = Utils.write2DArrayToMap(defaultStatsArr);

        //no need to check as they are constant
        EnumMap<ContestantAttribute, Integer> defaultStats = new EnumMap(defaultStatsMap);
        
        return defaultStats;
    }
}
