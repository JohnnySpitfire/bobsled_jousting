package org.beansinc.bobsled_jousting;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;


import org.beansinc.bobsled_jousting.BSExceptions.ObjectEffectNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectStatType;


public class Sled extends TeamObject<SledAttributes, SledModifiers>{
    
    public Sled(String name){
       
        super(name, SledAttributes.class, SledModifiers.class);
    }

    public Sled(String name, Object[][] sledModifiers) {

        super(name, SledAttributes.class, SledModifiers.class);
    }

}
