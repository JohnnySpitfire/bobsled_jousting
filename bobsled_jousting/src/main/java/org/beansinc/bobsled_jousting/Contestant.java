package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

/**
 * Constuctors for the contestant as well as generating the funds value for the contestant.
 */
public class Contestant extends TeamMember<ContestantAttribute, ContestantModifer>{
    
    private static final int CONTESTANT_BASE_VALUE = 200;
    
    /** How much each point of attribute is worth. */
    private static final int CONTESTANT_ATTRIBUTE_VALUE_FACTOR = 1;

    /** The contestant's nickname. */
    private String nickname;

    /**
     * Instantiates a new contestant.
     *
     * @param name the contestant's name
     * @throws InvalidObjectAttributeType
     */
    public Contestant(String name) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
    }
    
    /**
     * Instantiates a new contestant.
     *
     * @param name the name
     * @param nickname the nickname
     * @throws InvalidObjectAttributeType
     */
    public Contestant(String name, String nickname) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
        this.nickname = nickname;
    }

    /**
     * Instantiates a new contestant.
     *
     * @param name the name
     * @param attributes the attributes
     * @throws InvalidObjectAttributeType
     */
    public Contestant(String name, Object[][] attributes) throws InvalidObjectAttributeType{

        super(name, attributes, ContestantAttribute.class, ContestantModifer.class);
        this.setValue(this.generateContestantValue());

    }

    /**
     * Instantiates a new contestant.
     * Performs a shallow copy of a contestant.
     *
     * @param contestant the contestant to copy
     */
    public Contestant(Contestant contestant){

        super(contestant.getName(), 
            contestant.getAttributes(), 
            contestant.getModifiers(), 
            contestant.getValue());

        this.nickname = contestant.getNickname();
    }

    
    /** 
     * @return String
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Sets the nickname.
     *
     * @param name the new nickname
     */
    public void setNickname(String name){
        this.nickname = name;
    }

    /**
     * Update funds value of the contestant.
     */
    public void updateValue() {
        
        this.setValue(this.generateContestantValue());
    }

    /**
     * Generate the value of the contestant .
     *
     * @return the value of the contestant
     */
    private int generateContestantValue() {

        int contestantValue = CONTESTANT_BASE_VALUE;

        for(ContestantAttribute attr: this.getAttributes().keySet()) {

            contestantValue += this.getAttribute(attr) * CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
        }

        for(ContestantModifer mod: this.getModifiers()){

            contestantValue += mod.value * CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
        }

        return contestantValue;
    }
}
