package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

public class Market {
    
    private static int PLAYER_SALE_COUNT;
    private static int ITEM_SALE_COUNT;

    private ArrayList<Contestant> contestantSaleArr;
    private ArrayList<Item> itemSaleArr;

    public Market(Random rnd) throws InvalidObjectAttributeType {
        
        PLAYER_SALE_COUNT = 3 + rnd.nextInt(2);
        ITEM_SALE_COUNT = 3 + rnd.nextInt(2);

        this.contestantSaleArr = new ArrayList<Contestant>();
        this.itemSaleArr = new ArrayList<Item>();

        for (int i = 0; i < PLAYER_SALE_COUNT; i++) {
            Contestant newContestant = Utils.generateRandomContestant(rnd);
            this.contestantSaleArr.add(newContestant);
        }

        for (int i = 0; i < ITEM_SALE_COUNT; i++) {
            Item newItem = Item.getRandomItem(rnd);
            this.itemSaleArr.add(newItem);
        }
    }

    public ArrayList<Contestant> getContestantSaleArray() {
        return this.contestantSaleArr;
    }

    public ArrayList<Item> getItemSaleArray() {
        return this.itemSaleArr;
    }

    public <T> void sellAsset(PlayerTeam team, T asset) throws ItemNotFound {

        if(asset instanceof Contestant && (team.getActiveTeam().contains(asset) || team.getReserveTeam().contains(asset))) {

            Contestant contestant = (Contestant) asset;
            team.sellContestant(contestant);

        } else if (asset instanceof Item && team.getItems().contains(asset)) {

            Item item = (Item) asset;
            team.removeItem(item);
            team.modifyTotalFunds(item.value);
        }
    }

    public <T> void buyAsset(PlayerTeam team, T asset) throws InvalidTeamSize {

        if(asset instanceof Contestant && contestantSaleArr.contains(asset)) {

            Contestant contestant = (Contestant) asset;
            this.contestantSaleArr.remove(asset);
            team.purchaseContestant(contestant);

        } else if (asset instanceof Item && this.itemSaleArr.contains(asset)) {

            Item item = (Item) asset;
            this.itemSaleArr.remove(asset);
            team.addItem(item);
            team.modifyTotalFunds(-item.value);
        }
    }
}
