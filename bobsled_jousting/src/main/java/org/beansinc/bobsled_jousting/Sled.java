package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Sled extends TeamMember<SledAttribute, SledModifier>{

    private Ram ram;

    public Sled(String name) throws InvalidObjectAttributeType{
       
        super(name, SledAttribute.class, SledModifier.class);
        this.ram = Ram.WOODEN_RAM;
        this.setValue(this.ram.value);

    }
    
    public Sled(String name, Ram ramInput) throws InvalidObjectAttributeType{
       
        super(name, SledAttribute.class, SledModifier.class);
        this.setValue(ramInput.value);

    }

    public Sled(String name, Ram ramInput, Object[][] attributes) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);
        this.ram = ramInput;
        this.setValue(ramInput.value);
    }

    
    public Sled(String name, Ram ramInput, Object[][] attributes, SledModifier[] modifiers) throws InvalidObjectAttributeType {

        super(name, attributes, SledAttribute.class, SledModifier.class);

        int sledValue = ramInput.value;

        this.ram = ramInput;
        for(SledModifier modifier : modifiers) {
            this.addModifier(modifier);
            sledValue += modifier.value;
        }
        
        this.setValue(sledValue);
    }

    public Ram getRam() {
        return this.ram;
    }

    public void setRam(Ram ramInput) {
        this.ram = ramInput;
    }
}
