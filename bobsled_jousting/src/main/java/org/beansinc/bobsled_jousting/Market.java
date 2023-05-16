package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class Market {
    
    private static int PLAYER_SALE_COUNT;
    private static int ITEM_SALE_COUNT;

    private ArrayList<Contestant> contestantSaleArr;
    private ArrayList<Item> itemSaleArr;

    private Random rnd;

    public Market(Random rnd) throws InvalidObjectAttributeType {

        this.rnd = rnd;
        
        PLAYER_SALE_COUNT = 3 + rnd.nextInt(2);
        ITEM_SALE_COUNT = 3 + rnd.nextInt(2);

        for (int i = 0; i < PLAYER_SALE_COUNT - 1; i++) {
            Contestant newContestant = Utils.generateRandomContestant(rnd);
            contestantSaleArr.add(newContestant);
        }

        for (int i = 0; i < ITEM_SALE_COUNT - 1; i++) {
            Item newItem = Item.getRandomItem(rnd);
            itemSaleArr.add(newItem);
        }
    }

    public <T> void sellAsset(PlayerTeam team, T asset) {

        team.sellAsset(asset);
    }

    public <T> void buyAsset(PlayerTeam team, T asset) throws InvalidTeamSize {

        if(asset instanceof Contestant && contestantSaleArr.contains(asset)) {

            Contestant contestant = (Contestant) asset;
            this.contestantSaleArr.remove(asset);
            team.purchaseContestant(contestant);

        } else if (asset instanceof Item && this.itemSaleArr.contains(asset)) {

            Item item = (Item) asset;
            this.contestantSaleArr.remove(asset);
            team.addItem(item);
            team.modifyTotalFunds(item.value);
        }
    }
}
