package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Contestant extends TeamMember<ContestantAttributes, ContestantModifers>{
    
    private ContestantPositions contestantPosition;

    public Contestant(String name) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttributes.class, ContestantModifers.class);
        this.contestantPosition = ContestantPositions.RESERVE;
    }

    public Contestant(String name, ContestantPositions position) throws InvalidObjectAttributeType{
        
        super(name, ContestantAttributes.class, ContestantModifers.class);
        this.contestantPosition = position;
    }

    public Contestant(String name, ContestantPositions position, Object[][] attributes) throws InvalidObjectAttributeType{

        super(name, attributes, ContestantAttributes.class, ContestantModifers.class);
        this.contestantPosition = position;

    }

    public ContestantPositions getPosition(){
        
        return this.contestantPosition;
    }
}
