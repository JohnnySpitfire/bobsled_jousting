package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Contestant extends TeamMember<ContestantAttribute, ContestantModifer>{
    
    private ContestantPosition position;
    private String nickname;

    public Contestant(String name) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
        this.position = ContestantPosition.CENTRE;
    }
    
    public Contestant(String name, String nickname) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
        this.nickname = nickname;
        this.position = ContestantPosition.CENTRE;
    }

    public Contestant(String name, ContestantPosition position) throws InvalidObjectAttributeType{
        
        super(name, ContestantAttribute.class, ContestantModifer.class);
        this.position = position;
    }

    public Contestant(String name, ContestantPosition position, Object[][] attributes, int value) throws InvalidObjectAttributeType{

        super(name, attributes, ContestantAttribute.class, ContestantModifer.class);
        this.position = position;
        this.setValue(value);

    }

    public Contestant(Contestant contestant){

        super(contestant.getName(), 
            contestant.getAttributes(), 
            contestant.getModifiers(), 
            contestant.getValue());

        this.nickname = contestant.getNickname();
        this.position = contestant.getPosition();
    }

    
    /** 
     * @return ContestantPosition
     */
    public ContestantPosition getPosition(){
        
        return this.position;
    }

    public void setPosition(ContestantPosition pos){

        this.position = pos;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String name){
        this.nickname = name;
    }
}
