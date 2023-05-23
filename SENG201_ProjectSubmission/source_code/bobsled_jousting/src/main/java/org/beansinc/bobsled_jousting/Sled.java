package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

/**
 * Provides the constructors for sleds.
 */
public class Sled extends TeamMember<SledAttribute, SledModifier>{

    /** Base funds value of a sled. */
    private static final int SLED_BASE_VALUE = 100;
    
    /** How much each point of an attribute is worth. */
    private static final int SLED_ATTRIBUTE_VALUE_FACTOR = 2;

    /**
     * Instantiates a new sled.
     *
     * @param name the name of the sled
     * @throws InvalidObjectAttributeType
     */
    public Sled(String name) throws InvalidObjectAttributeType{
       
        super(name, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    /**
     * Instantiates a new sled.
     *
     * @param name the name
     * @param attributes Custom sled attributes, contains {Attributes, Integer} pairs
     * @throws InvalidObjectAttributeType
     */
    public Sled(String name, Object[][] attributes) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    
    /**
     * Instantiates a new sled.
     *
     * @param name the name
     * @param attributes Custom sled attributes, contains {Attributes, Integer} pairs
     * @param modifiers List of sled Modifiers
     * @throws InvalidObjectAttributeType
     */
    public Sled(String name, Object[][] attributes, SledModifier[] modifiers) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    /**
     * Instantiates a new sled.
     *
     * @param attributes Custom sled attributes, contains {Attributes, Integer} pairs
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Sled(Object[][] attributes) throws InvalidObjectAttributeType {

        super("PLACEHOLDER",attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    
    /** 
     * Generates the funds value of a sled.
     * 
     * @return int 
     */
    private int generateSledValue() {

        int ramValue = SLED_BASE_VALUE;

        for(SledAttribute attr: this.getAttributes().keySet()) {

            ramValue += this.getAttribute(attr) * SLED_ATTRIBUTE_VALUE_FACTOR;
        }

        for(SledModifier mod: this.getModifiers()){

            ramValue += mod.value * SLED_ATTRIBUTE_VALUE_FACTOR;
        }

        return ramValue;
    }
}
