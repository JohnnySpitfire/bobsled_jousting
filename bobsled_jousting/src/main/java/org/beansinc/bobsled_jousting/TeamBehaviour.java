package org.beansinc.bobsled_jousting;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public interface TeamBehaviour {
    
    public void onWeekEnd();
    public void onContestantPosSwap(Contestant contestant, ContestantPosition newPos);
    public void onItemPurchase(Item item, int cost);
    public void purchaseActivePlayer(Contestant contestant) throws InvalidTeamSize;
    public void purchaseReservePlayer(Contestant contestant) throws InvalidTeamSize;
    public void getNewRandomContestant(Contestant newContestant);
    public void onContestantQuit(Contestant contestant);
    public void onAthleteStatIncrease(Contestant contestant);
    public void onSellAsset();
}
