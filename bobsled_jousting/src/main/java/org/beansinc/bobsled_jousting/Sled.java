package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

// TODO: Auto-generated Javadoc
/**
 * The Class Sled.
 */
public class Sled extends TeamMember<SledAttribute, SledModifier>{

    /** The Constant SLED_BASE_VALUE. */
    private static final int SLED_BASE_VALUE = 100;
    
    /** The Constant SLED_ATTRIBUTE_VALUE_FACTOR. */
    private static final int SLED_ATTRIBUTE_VALUE_FACTOR = 2;

    /**
     * Instantiates a new sled.
     *
     * @param name the name
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Sled(String name) throws InvalidObjectAttributeType{
       
        super(name, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    /**
     * Instantiates a new sled.
     *
     * @param name the name
     * @param attributes the attributes
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Sled(String name, Object[][] attributes) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    
    /**
     * Instantiates a new sled.
     *
     * @param name the name
     * @param attributes the attributes
     * @param modifiers the modifiers
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Sled(String name, Object[][] attributes, SledModifier[] modifiers) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    /**
     * Instantiates a new sled.
     *
     * @param attributes the attributes
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Sled(Object[][] attributes) throws InvalidObjectAttributeType {

        super("PLACEHOLDER",attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    
    /** 
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
