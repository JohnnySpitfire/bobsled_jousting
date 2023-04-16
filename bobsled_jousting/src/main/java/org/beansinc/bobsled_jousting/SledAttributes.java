package org.beansinc.bobsled_jousting;

public enum SledAttributes {
    
    HEALTH,
    ARMOUR,
    SPEED,
    SEATS;

    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {HEALTH, 100},
            {ARMOUR, 100},
            {SPEED, 100},
            {SEATS, 5}
        };
    }

}
