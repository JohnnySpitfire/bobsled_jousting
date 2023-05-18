package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;



public class BaseTeam {
    
    public static final int MIN_ACTIVE_SIZE = 4;
    public static final int MAX_ACTIVE_SIZE = 4; //pls change me :(
    public static final int MIN_RESERVE_SIZE = 0;
    public static final int MAX_RESERVE_SIZE = 15;

    private String teamName;

    private int teamFunds;

    private ArrayList<Contestant> activeContestants;
    private ArrayList<Contestant> reserveContestants;
    
    private ArrayList<Item> items;

    private Sled teamSled;

    public BaseTeam() {
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamMoney = 1000;
    }
  
    public final Random rnd;

    public BaseTeam(String name, Random random) throws InvalidObjectAttributeType {

        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamFunds = 1000;
        this.items = new ArrayList<Item>();
        this.rnd = random;
    }

    public BaseTeam(String name, int funds, Random random) throws InvalidTeamSize, InvalidObjectAttributeType {
        
        this.teamName = name;
        this.activeContestants = new ArrayList<Contestant>();
        this.reserveContestants = new ArrayList<Contestant>();
        this.teamSled = new Sled(name + "'s Sled", Ram.WOODEN_RAM);
        this.teamFunds = funds;
        this.items = new ArrayList<Item>();
        this.rnd = random;
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

    public ArrayList<Contestant> getActiveTeam() {
     
        return this.activeContestants;
      
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

        if(this.activeContestants.size() > MAX_ACTIVE_SIZE) {
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

    public void removeActiveContestant(Contestant contestant) throws ContestantNotFound {

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

    public boolean isActiveTeamFull() {

        if(activeContestants.size() == MAX_ACTIVE_SIZE) {
            return true;
        } else {
            return false;
        }
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
