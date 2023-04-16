package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Sled extends TeamMember<SledAttributes, SledModifiers>{

    private Ram ram;

    public Sled(String name) throws InvalidObjectAttributeType{
       
        super(name, SledAttributes.class, SledModifiers.class);
        this.ram = Ram.WOODEN_RAM;

    }
    
    public Sled(String name, Ram ramInput) throws InvalidObjectAttributeType{
       
        super(name, SledAttributes.class, SledModifiers.class);
        this.ram = ramInput;

    }

    public Sled(String name, Ram ramInput, Object[][] sledModifiers) throws InvalidObjectAttributeType {

        super(name, sledModifiers, SledAttributes.class, SledModifiers.class);
        this.ram = ramInput;
    }

    public Ram getRam() {
        return this.ram;
    }

    public void setRam(Ram ramInput) {
        this.ram = ramInput;
    }
}
