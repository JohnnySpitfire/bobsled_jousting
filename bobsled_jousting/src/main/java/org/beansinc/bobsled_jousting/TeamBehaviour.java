package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

// TODO: Auto-generated Javadoc
/**
 * The Interface TeamBehaviour.
 */
public interface TeamBehaviour {
    
    /**
     * On week end.
     */
    public void onWeekEnd();
    
    /**
     * Swap contestant team.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
     */
    public void swapContestantTeam(Contestant contestant) throws InvalidTeamSize;
    
    /**
     * Purchase item.
     *
     * @param item the item
     * @param cost the cost
     */
    public void purchaseItem(Item item, int cost);
    
    /**
     * Purchase contestant.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
     */
    public void purchaseContestant(Contestant contestant) throws InvalidTeamSize;
    
    /**
     * Gets the new random contestant.
     *
     * @param difficulty the difficulty
     * @param currentWeek the current week
     * @return the new random contestant
     * @throws InvalidObjectAttributeType the invalid object attribute type
     * @throws InvalidTeamSize the invalid team size
     */
    public Contestant getNewRandomContestant(float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize;
    
    /**
     * Random contestant quit.
     *
     * @param difficulty the difficulty
     * @return the contestant
     * @throws ContestantNotFound the contestant not found
     * @throws InvalidTeamSize the invalid team size
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Contestant randomContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType;
    
    /**
     * Random contestant stat increase.
     *
     * @param difficulty the difficulty
     * @return the array list
     */
    public ArrayList<Contestant[]> randomContestantStatIncrease(float difficulty);
    
    /**
     * Sell contestant.
     *
     * @param contestant the contestant
     */
    public void sellContestant(Contestant contestant);
}
