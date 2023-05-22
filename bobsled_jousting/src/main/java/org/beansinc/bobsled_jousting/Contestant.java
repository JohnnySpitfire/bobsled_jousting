package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Contestant extends TeamMember<ContestantAttribute, ContestantModifer>{
    
    private static final int CONTESTANT_BASE_VALUE = 200;
    private static final int CONTESTANT_ATTRIBUTE_VALUE_FACTOR = 1;

    private String nickname;

    public Contestant(String name) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
    }
    
    public Contestant(String name, String nickname) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
        this.nickname = nickname;
    }

    public Contestant(String name, Object[][] attributes) throws InvalidObjectAttributeType{

        super(name, attributes, ContestantAttribute.class, ContestantModifer.class);
        this.setValue(this.generateContestantValue());

    }

    public Contestant(Contestant contestant){

        super(contestant.getName(), 
            contestant.getAttributes(), 
            contestant.getModifiers(), 
            contestant.getValue());

        this.nickname = contestant.getNickname();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String name){
        this.nickname = name;
    }

    public void updateValue() {
        
        this.setValue(this.generateContestantValue());
    }

    private int generateContestantValue() {

        int ramValue = CONTESTANT_BASE_VALUE;

        for(ContestantAttribute attr: this.getAttributes().keySet()) {

            ramValue += this.getAttribute(attr) * CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
        }

        for(ContestantModifer mod: this.getModifiers()){

            ramValue += mod.value * CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
        }

        return ramValue;
    }
}
