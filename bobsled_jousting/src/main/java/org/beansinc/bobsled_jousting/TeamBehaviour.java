package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

/**
 * A redundant interface, which could be used in the future to develop persistent computer teams.
 */
public interface TeamBehaviour {
    
    /**
     * Methods to run at the end of the week.
     */
    public void onWeekEnd();
    
    /**
     * Swaps contestant between the active and reserve teams.
     *
     * @param contestant the contestant to be swapped
     * @throws InvalidTeamSize
     */
    public void swapContestantTeam(Contestant contestant) throws InvalidTeamSize;
    
    /**
     * Purchase an item.
     *
     * @param item the item
     * @param cost the cost
     */
    public void purchaseItem(Item item, int cost);
    
    /**
     * Adds a contestant to the reserve team.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize
     */
    public void addContestant(Contestant contestant) throws InvalidTeamSize;
    
    /**
     * Gets the new random contestant.
     *
     * @param difficulty the difficulty of the game
     * @param currentWeek the current week
     * @return Contestant the new random contestant
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    public Contestant getNewRandomContestant(float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize;
    
    /**
     * Checks if a random contestant quit. If they quit they get removed from the team.
     *
     * @param difficulty the difficulty
     * @return Contestant If the a contestant quit, then that contestant would be returned. Otherwise, a new contestant with the name "null" will be returned.
     * @throws ContestantNotFound the contestant not found
     * @throws InvalidTeamSize the invalid team size
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public Contestant randomContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType;
    
    /**
     * Randomly increases the stats of selected contestants.
     *
     * @param difficulty the difficulty
     * @return ArrayList<Contestant[]> An ArrayList of {Upgraded Contestant, Old contestant} pairs. Not upgraded contestants are not included.
     */
    public ArrayList<Contestant[]> randomContestantStatIncrease(float difficulty);
    
    /**
     * Sells a contestant.
     *
     * @param contestant the contestant to be sold
     */
    public void sellContestant(Contestant contestant);

    /**
     * Trains a contestant.
     *
     * @param contestant the contestant to be trained
     * @return Contestant - the newly trained contestant
     */
    public Contestant trainContestant(Contestant contestant);
}
