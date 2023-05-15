package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

public class BaseTeam {
    
    public static final int MIN_ACTIVE_SIZE = 4;
    public static final int MAX_ACTIVE_SIZE = 4; //pls change me :(
    public static final int MIN_RESERVE_SIZE = 0;
    public static final int MAX_RESERVE_SIZE = 5;

    private String teamName;

    private int teamFunds;

    private ArrayList<Contestant> activeContestants;
    private ArrayList<Contestant> reserveContestants;
    
    private ArrayList<Item> items;

    private Sled teamSled;

    public BaseTeam(String name) throws InvalidObjectAttributeType {

        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamFunds = 1000;
        this.items = new ArrayList<Item>();

    }

    public BaseTeam(String name, int funds) throws InvalidTeamSize, InvalidObjectAttributeType {
        
        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamFunds = funds;
        this.items = new ArrayList<Item>();


    }

    public String getName() {
        
        return this.teamName;
    }

    public ArrayList<Contestant> getActiveTeam() {
        
        return this.activeContestants;
    }

    public ArrayList<Contestant> getReserveTeam() {

        return this.reserveContestants;
    }

    public Sled getSled() {

        return this.teamSled;
    }

    public int getTotalFunds() {
        return this.teamFunds;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) throws ItemNotFound {
        if(!this.items.contains(item)){
            throw new BSExceptions.ItemNotFound(item, this.items);
        }
        this.items.remove(item);
    }

    public void modifyTotalFunds(int difference){

        this.teamFunds += difference;
    }

    public void addActiveContestant(Contestant contestant) throws InvalidTeamSize {

        if(this.activeContestants.size() + 1 > MAX_ACTIVE_SIZE) {
            throw new InvalidTeamSize();
        }

        this.activeContestants.add(contestant);
    }

    public void addReserveContestant(Contestant contestant) throws InvalidTeamSize {

        if(this.reserveContestants.size() + 1 > MAX_RESERVE_SIZE) {
            throw new InvalidTeamSize();
        }

        this.reserveContestants.add(contestant);
    }

    public void removeActiveContestant(Contestant contestant) throws InvalidTeamSize, ContestantNotFound {

        if(this.activeContestants.size() - 1 < MIN_ACTIVE_SIZE) {
            throw new InvalidTeamSize();
        }
        if (!this.activeContestants.contains(contestant)) {
            throw new ContestantNotFound(contestant, teamName);
        }
        this.activeContestants.remove(contestant);
    }

    public void removeReserveContestant(Contestant contestant) throws InvalidTeamSize, ContestantNotFound {

        if(this.reserveContestants.size() - 1 < MIN_RESERVE_SIZE) {
            throw new InvalidTeamSize();
        }
        if (!this.reserveContestants.contains(contestant)) {
            throw new ContestantNotFound(contestant, teamName);
        }
        this.reserveContestants.remove(contestant);
    }

    public void modifyActiveContestant(Contestant modifiedContestant, Contestant oldContestant) {

        if(!this.activeContestants.contains(oldContestant)){
            throw new BSExceptions.ContestantNotFound(oldContestant, teamName);
        }

        int contestantIndex = this.activeContestants.indexOf(oldContestant);
        this.activeContestants.set(contestantIndex, modifiedContestant);
    }

    public void modifyReserveContestant(Contestant modifiedContestant, Contestant oldContestant) {

        if(!this.reserveContestants.contains(oldContestant)){
            throw new BSExceptions.ContestantNotFound(oldContestant, teamName);
        }

        int contestantIndex = this.activeContestants.indexOf(oldContestant);
        this.reserveContestants.set(contestantIndex, modifiedContestant);
    }


    public void swapSled(Sled newSled) {

        this.teamSled = newSled;
        
    }

}
