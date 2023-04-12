package org.beansinc.bobsled_jousting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ContestantEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidContestantStatType;


public class Contestant {
    
    private String contestantName;
    private ContestantPositions contestantPosition;
    private HashMap<ContestantAttributes, Integer> contestantStats;
    private HashSet<ContestantEffects> contestantEffects;

    public Contestant(String name){

        this.contestantName = name;
        this.contestantPosition = ContestantPositions.OTHER;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = new HashSet<>();
    }

    public Contestant(String name, ContestantPositions position){
        
        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = new HashSet<>();

    }

    public Contestant(String name, ContestantPositions position, Object[][] stats) throws InvalidContestantStatType{

        this.contestantName = name;
        this.contestantPosition = position;
        this.contestantStats = this.generateDefaultStatsMap();
        this.contestantEffects = new HashSet<>();

        for (Object[] stat : stats) {
            if(!(stat[0] instanceof ContestantAttributes) || !(stat[1] instanceof Integer)) {
                throw new BSExceptions.InvalidContestantStatType(stat[0], stat[1]);
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

    public Map<ContestantAttributes, Integer> getStats(){

        return this.contestantStats;
    }

    public HashSet<ContestantEffects> getEffects(){
        
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

    public void AddEffect(ContestantEffects effect) {

        this.contestantEffects.add(effect);
    }

    public void RemoveEffect(ContestantEffects effect) throws ContestantEffectNotFound {

        if(!this.contestantEffects.contains(effect)) {
            throw new BSExceptions.ContestantEffectNotFound(effect, this.contestantName);
        } else {
            this.contestantEffects.remove(effect);
        }
    }
 
    private HashMap<ContestantAttributes, Integer> generateDefaultStatsMap(){

        Object[][] defaultStatsArr = ContestantAttributes.getDefaultAttributes();
        Map<?,?> defaultStatsMap = Utils.write2DArrayToMap(defaultStatsArr);

        //no need to check as they are constant
        HashMap<ContestantAttributes, Integer> defaultStats = (HashMap<ContestantAttributes, Integer>) defaultStatsMap;
        
        return defaultStats;
    }
}
