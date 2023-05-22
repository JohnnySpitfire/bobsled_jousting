package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseTeam.
 */
public class BaseTeam {
    
    /** The Constant MAX_ACTIVE_SIZE. */
    public static final int MAX_ACTIVE_SIZE = 4;
    
    /** The Constant MAX_RESERVE_SIZE. */
    public static final int MAX_RESERVE_SIZE = 5;

    /** The team name. */
    private String teamName;

    /** The team funds. */
    private int teamFunds;

    /** The active contestants. */
    private ArrayList<Contestant> activeContestants;
    
    /** The reserve contestants. */
    private ArrayList<Contestant> reserveContestants;
    
    /** The items. */
    private ArrayList<Item> items;

    /** The team sled. */
    private Sled teamSled;

    /** The rnd. */
    public final Random rnd;

    /**
     * Instantiates a new base team.
     *
     * @param name the name
     * @param random the random
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public BaseTeam(String name, Random random) throws InvalidObjectAttributeType {

        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled");
        this.teamFunds = 1000;
        this.items = new ArrayList<Item>();
        this.rnd = random;

    }

    /**
     * Instantiates a new base team.
     *
     * @param name the name
     * @param funds the funds
     * @param random the random
     * @throws InvalidTeamSize the invalid team size
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public BaseTeam(String name, int funds, Random random) throws InvalidTeamSize, InvalidObjectAttributeType {
        
        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled");
        this.teamFunds = funds;
        this.items = new ArrayList<Item>();
        this.rnd = random;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        
        return this.teamName;
    }

    /**
     * Gets the active team.
     *
     * @return the active team
     */
    public ArrayList<Contestant> getActiveTeam() {
        
        return this.activeContestants;
    }

    /**
     * Gets the reserve team.
     *
     * @return the reserve team
     */
    public ArrayList<Contestant> getReserveTeam() {

        return this.reserveContestants;
    }

    /**
     * Gets the sled.
     *
     * @return the sled
     */
    public Sled getSled() {

        return this.teamSled;
    }

    /**
     * Gets the total funds.
     *
     * @return the total funds
     */
    public int getTotalFunds() {
        return this.teamFunds;
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /**
     * Adds the item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Removes the item.
     *
     * @param item the item
     * @throws ItemNotFound the item not found
     */
    public void removeItem(Item item) throws ItemNotFound {
        if(!this.items.contains(item)){
            throw new BSExceptions.ItemNotFound(item, this.items);
        }
        this.items.remove(item);
    }

    /**
     * Modify total funds.
     *
     * @param difference the difference
     */
    public void modifyTotalFunds(int difference){

        this.teamFunds += difference;
    }

    /**
     * Adds the active contestant.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
     */
    public void addActiveContestant(Contestant contestant) throws InvalidTeamSize {

        if(this.activeContestants.size() > MAX_ACTIVE_SIZE) {
            throw new InvalidTeamSize(this);
        }

        this.activeContestants.add(contestant);
    }

    /**
     * Adds the reserve contestant.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
     */
    public void addReserveContestant(Contestant contestant) throws InvalidTeamSize {

        if(this.reserveContestants.size() > MAX_RESERVE_SIZE) {
            throw new InvalidTeamSize(this);
        }

        this.reserveContestants.add(contestant);
    }

    /**
     * Removes the active contestant.
     *
     * @param contestant the contestant
     * @throws ContestantNotFound the contestant not found
     */
    public void removeActiveContestant(Contestant contestant) throws ContestantNotFound {

        if (!this.activeContestants.contains(contestant)) {
            throw new ContestantNotFound(contestant, teamName);
        }
        this.activeContestants.remove(contestant);
    }

    /**
     * Removes the reserve contestant.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
     * @throws ContestantNotFound the contestant not found
     */
    public void removeReserveContestant(Contestant contestant) throws InvalidTeamSize, ContestantNotFound {

        if(this.reserveContestants.size() - 1 < 0) {
            throw new InvalidTeamSize(this);
        }
        if (!this.reserveContestants.contains(contestant)) {
            throw new ContestantNotFound(contestant, teamName);
        }
        this.reserveContestants.remove(contestant);
    }

    /**
     * Modify active contestant.
     *
     * @param modifiedContestant the modified contestant
     * @param oldContestant the old contestant
     */
    public void modifyActiveContestant(Contestant modifiedContestant, Contestant oldContestant) {

        if(!this.activeContestants.contains(oldContestant)){
            throw new BSExceptions.ContestantNotFound(oldContestant, teamName);
        }

        int contestantIndex = this.activeContestants.indexOf(oldContestant);
        this.activeContestants.set(contestantIndex, modifiedContestant);
    }

    /**
     * Modify reserve contestant.
     *
     * @param modifiedContestant the modified contestant
     * @param oldContestant the old contestant
     */
    public void modifyReserveContestant(Contestant modifiedContestant, Contestant oldContestant) {

        if(!this.reserveContestants.contains(oldContestant)){
            throw new BSExceptions.ContestantNotFound(oldContestant, teamName);
        }

        int contestantIndex = this.activeContestants.indexOf(oldContestant);
        this.reserveContestants.set(contestantIndex, modifiedContestant);
    }

    /**
     * Checks if is active team full.
     *
     * @return true, if is active team full
     */
    public boolean isActiveTeamFull() {

        if(activeContestants.size() == MAX_ACTIVE_SIZE) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Swap sled.
     *
     * @param newSled the new sled
     */
    public void swapSled(Sled newSled) {

        this.teamSled = newSled;
        
    }

}
