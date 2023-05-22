package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

// TODO: Auto-generated Javadoc
/**
 * The Class Contestant.
 */
public class Contestant extends TeamMember<ContestantAttribute, ContestantModifer>{
    
    /** The Constant CONTESTANT_BASE_VALUE. */
    private static final int CONTESTANT_BASE_VALUE = 200;
    
    /** The Constant CONTESTANT_ATTRIBUTE_VALUE_FACTOR. */
    private static final int CONTESTANT_ATTRIBUTE_VALUE_FACTOR = 1;

    /** The nickname. */
    private String nickname;

    /**
     * Instantiates a new contestant.
     *
     * @param name the name
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Contestant(String name) throws InvalidObjectAttributeType{
       
        super(name, ContestantAttribute.class, ContestantModifer.class);
    }
    
    /**
     * Instantiates a new contestant.
     *
     * @param name the name
     * @param nickname the nickname
     * @throws InvalidObjectAttributeType the invalid object attribute type
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
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Contestant(String name, Object[][] attributes) throws InvalidObjectAttributeType{

        super(name, attributes, ContestantAttribute.class, ContestantModifer.class);
        this.setValue(this.generateContestantValue());

    }

    /**
     * Instantiates a new contestant.
     *
     * @param contestant the contestant
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
     * Update value.
     */
    public void updateValue() {
        
        this.setValue(this.generateContestantValue());
    }

    /**
     * Generate contestant value.
     *
     * @return the int
     */
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
