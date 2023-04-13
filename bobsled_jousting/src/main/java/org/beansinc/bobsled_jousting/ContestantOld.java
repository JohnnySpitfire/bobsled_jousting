package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectStatType;


public class ContestantOld {
    
    private String contestantName;
    private ContestantPositions contestantPosition;
    private EnumMap<ContestantAttributes, Integer> contestantStats;
    private EnumSet<SledModifers> contestantEffects;

    public ContestantOld(String name){

        this.contestantName = name;
        this.contestantPosition = ContestantPositions.OTHER;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(SledModifers.class);
    }

    public ContestantOld(String name, ContestantPositions position){
        
        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(SledModifers.class);

    }

    public ContestantOld(String name, ContestantPositions position, Object[][] stats) throws InvalidObjectStatType{

        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = EnumSet.noneOf(SledModifers.class);

        for (Object[] stat : stats) {
            if(!(stat[0] instanceof ContestantAttributes) || !(stat[1] instanceof Integer)) {
                throw new BSExceptions.InvalidObjectStatType(stat[0], stat[1]);
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

    public EnumSet<SledModifers> getEffects(){
        
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

    public void AddEffect(SledModifers effect) {

        this.contestantEffects.add(effect);
    }

    public void RemoveEffect(SledModifers effect) throws ObjectEffectNotFound {

        if(!this.contestantEffects.contains(effect)) {
            throw new BSExceptions.ObjectEffectNotFound(effect);
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
