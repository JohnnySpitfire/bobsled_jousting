package org.beansinc.bobsled_jousting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class MarketTest {

    PlayerTeam team;
    Market market;
    Random rnd;
    
    @BeforeEach 
    void initalize() throws InvalidObjectAttributeType, InvalidTeamSize {
        
        rnd = new Random();
        int currentWeek = rnd.nextInt(14);
        market = new Market(rnd, 0);
        team = new PlayerTeam("test", 0, rnd);

        for(int i = 0; i < BaseTeam.MAX_ACTIVE_SIZE; i++) {
            team.addActiveContestant(Utils.generateRandomContestant(rnd,currentWeek));
        }

        for(int i = 0; i < BaseTeam.MAX_RESERVE_SIZE; i++) {
            team.addReserveContestant(Utils.generateRandomContestant(rnd,currentWeek));
        }

        for(int i = 0; i < 10; i++) {
            team.addItem(Item.getRandomItem(rnd));
        }    
    }

    @RepeatedTest(200)
    @Test
    void testBuyContestant() throws InvalidTeamSize {

        ArrayList<Contestant> oldContestantSaleArr = new ArrayList<Contestant>();
        oldContestantSaleArr.addAll(market.getContestantSaleArray());

        int rndContestantIndex = rnd.nextInt(market.getContestantSaleArray().size() - 1);
        Contestant rndContestant = market.getContestantSaleArray().get(rndContestantIndex);

        market.buyAsset(team, rndContestant);

        assertEquals(oldContestantSaleArr.size() - 1, market.getContestantSaleArray().size());
        assertNotEquals(oldContestantSaleArr, market.getContestantSaleArray());
        assertTrue(this.team.getReserveTeam().contains(rndContestant));

    }

    @RepeatedTest(200)
    @Test
    void testBuyItem() throws InvalidTeamSize {

        ArrayList<Item> oldItemSaleArr = new ArrayList<Item>();
        oldItemSaleArr.addAll(market.getItemSaleArray());

        int rndItemIndex = rnd.nextInt(market.getItemSaleArray().size() - 1);
        Item rndItem = market.getItemSaleArray().get(rndItemIndex);

        market.buyAsset(team, rndItem);

        assertEquals(oldItemSaleArr.size() - 1, market.getItemSaleArray().size());
        assertNotEquals(oldItemSaleArr, market.getItemSaleArray());
        assertTrue(this.team.getItems().contains(rndItem));

    }

    @RepeatedTest(200)
    @Test
    void testSellContestant() throws ItemNotFound {

        ArrayList<Contestant> oldActiveContestants = new ArrayList<Contestant>();
        oldActiveContestants.addAll(team.getActiveTeam());

        ArrayList<Contestant> oldReserveContestants = new ArrayList<Contestant>();
        oldReserveContestants.addAll(team.getReserveTeam());

        int rndActiveIndex = rnd.nextInt(team.getActiveTeam().size() - 1);
        Contestant rndActiveContestant = team.getActiveTeam().get(rndActiveIndex);

        int rndReserveIndex = rnd.nextInt(team.getReserveTeam().size() - 1);
        Contestant rndReserveContestant = team.getReserveTeam().get(rndReserveIndex);

        market.sellAsset(team, rndActiveContestant);
        market.sellAsset(team, rndReserveContestant);

        assertEquals(oldActiveContestants.size() - 1, team.getActiveTeam().size());
        assertNotEquals(oldActiveContestants, team.getActiveTeam());

        assertEquals(oldReserveContestants.size() - 1, team.getReserveTeam().size());
        assertNotEquals(oldReserveContestants, team.getReserveTeam());
        assertFalse(this.team.getActiveTeam().contains(rndActiveContestant));
        assertFalse(this.team.getReserveTeam().contains(rndReserveContestant));



    }

    @RepeatedTest(200)
    @Test
    void testSellItem() throws ItemNotFound {

        ArrayList<Item> oldTeamItems = new ArrayList<Item>();
        oldTeamItems.addAll(team.getItems());

        int rndItemIndex = rnd.nextInt(team.getItems().size() - 1);
        Item rndItem = team.getItems().get(rndItemIndex);

        market.sellAsset(team, rndItem);
        
        assertEquals(oldTeamItems.size() - 1, team.getItems().size());
        assertNotEquals(oldTeamItems, team.getItems());

    }

    @RepeatedTest(200)
    @Test
    void testContestantTeamSwap() throws InvalidTeamSize {

        

        ArrayList<Contestant> oldActiveContestants = new ArrayList<Contestant>();
        oldActiveContestants.addAll(team.getActiveTeam());

        ArrayList<Contestant> oldReserveContestants = new ArrayList<Contestant>();
        oldReserveContestants.addAll(team.getReserveTeam());

        int rndActiveIndex = rnd.nextInt(team.getActiveTeam().size() - 1);
        Contestant rndActiveContestant = team.getActiveTeam().get(rndActiveIndex);

        int rndReserveIndex = rnd.nextInt(team.getReserveTeam().size() - 1);
        Contestant rndReserveContestant = team.getReserveTeam().get(rndReserveIndex);

        team.swapContestantTeam(rndActiveContestant);
        team.swapContestantTeam(rndReserveContestant);


        assertEquals(oldActiveContestants.size(), team.getActiveTeam().size());
        assertNotEquals(oldActiveContestants, team.getActiveTeam());

        assertEquals(oldReserveContestants.size(), team.getReserveTeam().size());
        assertNotEquals(oldReserveContestants, team.getReserveTeam());

        assertTrue(this.team.getReserveTeam().contains(rndActiveContestant));
        assertTrue(this.team.getActiveTeam().contains(rndReserveContestant));

    }

}
