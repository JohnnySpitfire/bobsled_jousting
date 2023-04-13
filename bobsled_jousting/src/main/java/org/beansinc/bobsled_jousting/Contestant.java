package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectStatType;


public class Contestant extends TeamObject<ContestantAttributes, SledModifers>{
    
    private String contestantName;
    private ContestantPositions contestantPosition;

    public Contestant(String name){
       
        super(name, ContestantAttributes.class, SledModifers.class);
        
        this.contestantName = name;
        this.contestantPosition = ContestantPositions.OTHER;
    }

    public Contestant(String name, ContestantPositions position){
        
        super(name, ContestantAttributes.class, SledModifers.class);

        this.contestantName = name;
        this.contestantPosition = position;
    }

    public Contestant(String name, ContestantPositions position, Object[][] stats) throws InvalidObjectStatType{

        super(name, ContestantAttributes.class, SledModifers.class);

        this.contestantName = name;
        this.contestantPosition = position;

    }

    public String getName(){

        return this.contestantName;
    }

    public ContestantPositions getPosition(){
        
        return this.contestantPosition;
    }
}
