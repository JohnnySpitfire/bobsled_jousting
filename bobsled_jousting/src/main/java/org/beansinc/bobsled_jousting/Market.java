package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

public class Market {
    
    private static int PLAYER_SALE_COUNT;
    private static int ITEM_SALE_COUNT;

    private ArrayList<Contestant> contestantSaleArr;
    private ArrayList<Item> itemSaleArr;

    public Market(Random rnd) {
        
        PLAYER_SALE_COUNT = 3 + rnd.nextInt(2);
        ITEM_SALE_COUNT = 3 + rnd.nextInt(2);

        
    }
}
