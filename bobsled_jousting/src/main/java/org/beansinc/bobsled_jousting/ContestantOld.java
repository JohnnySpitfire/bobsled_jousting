package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

@SuppressWarnings("unchecked")
public class ContestantOld {
    
    private String contestantName;
    private ContestantPositions contestantPosition;
    private EnumMap<ContestantAttributes, Integer> contestantStats;
    private EnumSet<ContestantModifers> contestantEffects;

    public ContestantOld(String name){

        this.contestantName = name;
        this.contestantPosition = ContestantPositions.OTHER;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifers.class);
    }

    public ContestantOld(String name, ContestantPositions position){
        
        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifers.class);

    }

    public ContestantOld(String name, ContestantPositions position, Object[][] stats) throws InvalidObjectAttributeType{

        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(ContestantModifers.class);

        for (Object[] stat : stats) {
            if(!(stat[0] instanceof ContestantAttributes) || !(stat[1] instanceof Integer)) {
                // throw new InvalidObjectAttributeType(stat[0], stat[1]);
            } else {
                this.contestantStats.put((ContestantAttributes) stat[0], (Integer) stat[1]);
            }
        }
    }

    public String getName(){

        return this.contestantName;
    }

    public ContestantPositions getPosition(){
        
        return this.contestantPosition;
    }

    public EnumMap<ContestantAttributes, Integer> getStats(){

        return this.contestantStats;
    }

    public EnumSet<ContestantModifers> getEffects(){
        
        return this.contestantEffects;
    }

    public void SetPosition(ContestantPositions position){
        
        this.contestantPosition = position;
    }

    public void AddStat(ContestantAttributes stat, int value){

        this.contestantStats.put(stat, value);
    }

    public void RemoveStat(ContestantAttributes stat) {

        this.contestantStats.remove(stat);
    }

    public void AddEffect(ContestantModifers effect) {

        this.contestantEffects.add(effect);
    }

    public void RemoveEffect(ContestantModifers effect) throws ObjectEffectNotFound {

        if(!this.contestantEffects.contains(effect)) {
            throw new ObjectEffectNotFound(effect);
        } else {
            this.contestantEffects.remove(effect);
        }
    }
 
    private EnumMap<ContestantAttributes, Integer> generateDefaultStatsMap(){

        Object[][] defaultStatsArr = ContestantAttributes.getDefaultAttributes();
        Map<?,?> defaultStatsMap = Utils.write2DArrayToMap(defaultStatsArr);

        //no need to check as they are constant
        EnumMap<ContestantAttributes, Integer> defaultStats = new EnumMap(defaultStatsMap);
        
        return defaultStats;
    }
}
