package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;



public class BaseTeam {
    
    public static final int MIN_ACTIVE_SIZE = 4;
    public static final int MAX_ACTIVE_SIZE = 10;
    public static final int MIN_RESERVE_SIZE = 0;
    public static final int MAX_RESERVE_SIZE = 5;

    private String teamName;

    private int teamMoney;

    private ArrayList<Contestant> activeContestants;
    private ArrayList<Contestant> reserveContestants;

    private Sled teamSled;

    public BaseTeam() {
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamMoney = 1000;

    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr) throws InvalidTeamSize, InvalidObjectAttributeType {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamMoney = 1000;

    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr, ArrayList<Contestant> reserveContestantsArr) throws InvalidTeamSize, InvalidObjectAttributeType {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = reserveContestantsArr;
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamMoney = 1000;

    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr, ArrayList<Contestant> reserveContestantsArr, Sled sledInput) throws InvalidTeamSize, InvalidObjectAttributeType {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = reserveContestantsArr;
        this.teamSled = sledInput;
        this.teamMoney = 1000;

    }

    public BaseTeam(String name, ArrayList<Contestant> activeContestantsArr, ArrayList<Contestant> reserveContestantsArr, Sled sledInput, int moneyInput) throws InvalidTeamSize, InvalidObjectAttributeType {

        if(activeContestantsArr.size() < MIN_ACTIVE_SIZE) {
            throw new BSExceptions.InvalidTeamSize();
        }
        
        this.teamName = name;
        this.activeContestants = activeContestantsArr;
        this.reserveContestants = reserveContestantsArr;
        this.teamSled = sledInput;
        this.teamMoney = moneyInput;

    }

    public String getName() {
        
        return this.teamName;
    }
    
    public void setName(String incomingName) throws InvalidObjectAttributeType {
    	teamName = incomingName;
    	setSled(teamName);
    }
    
    public void setSled(String name) throws InvalidObjectAttributeType {
    	this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
    }
    
    public int getMoney() {
    	return this.teamMoney;
    }

    public void alterMoney(int number) {
    	teamMoney += number;
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

    public void swapSled(Sled newSled) {

        this.teamSled = newSled;
        
    }
    
    public void launchMainMenuScreen() {
		MainMenuScreen mainWindow = new MainMenuScreen(this);
	}
    
    public void closeMainMenuScreen(MainMenuScreen mainWindow) {
		mainWindow.closeWindow();
	}
    
    public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
    
    public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainMenuScreen();
	}
    
    public void launchInventoryScreen() {
    	InventoryScreen inventoryWindow = new InventoryScreen(this);
	}
    
    public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
		launchMainMenuScreen();
	}
    
    public void launchClubScreen() {
    	InventoryScreen clubWindow = new InventoryScreen(this);
	}
    
    public void closeClubScreen(ClubScreen clubWindow) {
		clubWindow.closeWindow();
		launchMainMenuScreen();
	}
    
    public void launchStoreScreen() {
    	StoreScreen storeWindow = new StoreScreen(this);
	}
    
    public void closeStoreScreen(StoreScreen storeWindow) {
		storeWindow.closeWindow();
		launchMainMenuScreen();
	}
}
