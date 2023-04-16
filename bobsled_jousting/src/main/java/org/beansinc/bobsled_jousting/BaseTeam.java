package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class BaseTeam {
    
    public static final int MIN_ACTIVE_SIZE = 4;
    public static final int MAX_ACTIVE_SIZE = 10;
    public static final int MIN_RESERVE_SIZE = 0;
    public static final int MAX_RESERVE_SIZE = 5;

    private String teamName;
    private ArrayList<Contestant> activeContestants;
    private ArrayList<Contestant> reserveContestants;

    public BaseTeam(String name){

        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr) throws InvalidTeamSize {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = new ArrayList<Contestant>();
    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr, ArrayList<Contestant> reserveContestantsArr) throws InvalidTeamSize {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = reserveContestantsArr;

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

}
