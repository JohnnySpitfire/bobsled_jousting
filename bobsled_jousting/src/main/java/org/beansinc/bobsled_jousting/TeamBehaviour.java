package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public interface TeamBehaviour {
    
    public void onWeekEnd();
    public void onContestantPosSwap(Contestant contestant, ContestantPosition newPos);
    public void onItemPurchase(Item item, int cost);
    public void purchaseContestant(Contestant contestant) throws InvalidTeamSize;
    public Contestant getNewRandomContestant(float difficulty) throws InvalidObjectAttributeType, InvalidTeamSize;
    public Contestant onContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType;
    public ArrayList<Contestant[]> onAthleteStatIncrease(float difficulty);
    public void sellContestant(Contestant contestant);
}
