package org.beansinc.bobsled_jousting;

public enum SledAttributes {
    
    ARMOUR,
    SPEED,
    SEATS;

    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {ARMOUR, 100},
            {SPEED, 100},
            {SEATS, 5}
        };
    }

}
