package org.beansinc.bobsled_jousting;

public enum ContestantAttributes {
    OFFENCE,
    DEFENCE,
    STANIMA,
    ALCOHOL_CONSUMED;

    public static Object[][] getDefaultAttributes(){
        return new Object[][]{
            {OFFENCE, 100},
            {DEFENCE, 100},
            {STANIMA, 100}
        };
    }
}
