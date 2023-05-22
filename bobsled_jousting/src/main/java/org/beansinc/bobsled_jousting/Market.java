package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

// TODO: Auto-generated Javadoc
/**
 * The Class Market.
 */
public class Market {
    
    /** The player sale count. */
    private static int PLAYER_SALE_COUNT;
    
    /** The item sale count. */
    private static int ITEM_SALE_COUNT;
    
    /** The sled sale count. */
    private static int SLED_SALE_COUNT;

    /** The contestant sale arr. */
    private ArrayList<Contestant> contestantSaleArr;
    
    /** The item sale arr. */
    private ArrayList<Item> itemSaleArr;
    
    /** The sled sale arr. */
    private ArrayList<Sled> sledSaleArr;

    /**
     * Instantiates a new market.
     *
     * @param rnd the rnd
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Market(Random rnd, int currentWeek) throws InvalidObjectAttributeType {
        
        PLAYER_SALE_COUNT = 3 + rnd.nextInt(3);
        ITEM_SALE_COUNT = 3 + rnd.nextInt(3);
        SLED_SALE_COUNT = 3 + rnd.nextInt(3);

        this.contestantSaleArr = new ArrayList<Contestant>();
        this.itemSaleArr = new ArrayList<Item>();
        this.sledSaleArr = new ArrayList<Sled>();

        for (int i = 0; i < PLAYER_SALE_COUNT; i++) {
            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.contestantSaleArr.add(newContestant);
        }

        for (int i = 0; i < ITEM_SALE_COUNT; i++) {
            Item newItem = Item.getRandomItem(rnd);
            this.itemSaleArr.add(newItem);
        }

        for (int i = 0; i < SLED_SALE_COUNT; i++) {
            Sled newSled = Utils.generateRandomSled(rnd, currentWeek);
            this.sledSaleArr.add(newSled);
        }
    }

    
    /** 
     * @return ArrayList<Contestant>
     */
    public ArrayList<Contestant> getContestantSaleArray() {
        return this.contestantSaleArr;
    }

    /**
     * Gets the item sale array.
     *
     * @return the item sale array
     */
    public ArrayList<Item> getItemSaleArray() {
        return this.itemSaleArr;
    }

    /**
     * Gets the sled sale array.
     *
     * @return the sled sale array
     */
    public ArrayList<Sled> getSledSaleArray() {
        return this.sledSaleArr;
    }

    /**
     * Sell asset.
     *
     * @param <T> the generic type
     * @param team the team
     * @param asset the asset
     * @throws ItemNotFound the item not found
     */
    public <T> void sellAsset(PlayerTeam team, T asset) throws ItemNotFound {

        if(asset instanceof Contestant && (team.getActiveTeam().contains(asset) || team.getReserveTeam().contains(asset))) {

            Contestant contestant = (Contestant) asset;
            team.sellContestant(contestant);
            this.contestantSaleArr.add(contestant);

        } else if (asset instanceof Item && team.getItems().contains(asset)) {

            Item item = (Item) asset;
            team.removeItem(item);
            team.modifyTotalFunds(item.value);
            this.itemSaleArr.add(item);

        }
    }

    /**
     * Buy asset.
     *
     * @param <T> the generic type
     * @param team the team
     * @param asset the asset
     * @throws InvalidTeamSize the invalid team size
     */
    public <T> void buyAsset(PlayerTeam team, T asset) throws InvalidTeamSize {

        if(asset instanceof Contestant && this.contestantSaleArr.contains(asset)) {

            Contestant contestant = (Contestant) asset;
            this.contestantSaleArr.remove(asset);
            team.purchaseContestant(contestant);

        } else if (asset instanceof Item && this.itemSaleArr.contains(asset)) {

            Item item = (Item) asset;
            this.itemSaleArr.remove(asset);
            team.addItem(item);
            team.modifyTotalFunds(-item.value);

        } else if (asset instanceof Sled && this.sledSaleArr.contains(asset)) {

            Sled sled = (Sled) asset;
            Sled oldSled = team.getSled();

            int priceDifference = team.getSled().getValue() - sled.getValue();

            this.sledSaleArr.remove(sled);
            team.swapSled(sled);
            team.modifyTotalFunds(priceDifference);
            this.sledSaleArr.add(oldSled);
        }
    }
}
