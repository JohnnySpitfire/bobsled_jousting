package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Sled extends TeamMember<SledAttribute, SledModifier>{

    private static final int SLED_BASE_VALUE = 100;
    private static final int SLED_ATTRIBUTE_VALUE_FACTOR = 2;

    public Sled(String name) throws InvalidObjectAttributeType{
       
        super(name, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    public Sled(String name, Object[][] attributes) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    
    public Sled(String name, Object[][] attributes, SledModifier[] modifiers) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

    public Sled(Object[][] attributes) throws InvalidObjectAttributeType {

        super("PLACEHOLDER",attributes, SledAttribute.class, SledModifier.class);
        this.setValue(this.generateSledValue());
    }

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
