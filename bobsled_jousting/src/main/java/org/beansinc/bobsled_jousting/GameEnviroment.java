package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

// TODO: Auto-generated Javadoc
/**
 * The Class GameEnviroment.
 */
public class GameEnviroment {

   /** The total season weeks. */
   private int totalSeasonWeeks;
   
   /** The current week. */
   private int currentWeek;

   /** The difficulty. */
   private float difficulty;

   /** The player team. */
   private PlayerTeam playerTeam;
   
   /** The game. */
   private GameEnviroment game;

   /** The market. */
   Market market;
   
   /** The stadium. */
   Stadium stadium;

   /** The rnd. */
   Random rnd;

   /**
    * Instantiates a new game enviroment.
    *
    * @param teamName the team name
    * @param totalWeeks the total weeks
    * @param difficulty the difficulty
    * @throws InvalidObjectAttributeType the invalid object attribute type
    */
   public GameEnviroment(String teamName, int totalWeeks, int difficulty) throws InvalidObjectAttributeType {

      this.rnd = new Random();
      this.totalSeasonWeeks = totalWeeks;
      this.currentWeek = 0;
      this.difficulty = 1f - (float) (difficulty)/100f;

      this.market = new Market(this.rnd, this.currentWeek);

      int startingFunds = (int) (2000 + 1000 * this.difficulty);

      try {
         this.playerTeam = new PlayerTeam(teamName, startingFunds, this.rnd);
      } catch (InvalidObjectAttributeType e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (InvalidTeamSize e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      
   }

   
   /**
    *  
    *
    * @param activeContestants the active contestants
    * @param reserveContestants the reserve contestants
    * @throws InvalidTeamSize the invalid team size
    */
   public void gameStart(ArrayList<Contestant> activeContestants, ArrayList<Contestant> reserveContestants) throws InvalidTeamSize {

      for(Contestant contestant : activeContestants) {
         this.playerTeam.addActiveContestant(contestant);
      }

      for(Contestant contestant : reserveContestants) {
         this.playerTeam.addReserveContestant(contestant);
      }

   }

   /**
    * Game week.
    *
    * @throws ContestantNotFound the contestant not found
    * @throws InvalidTeamSize the invalid team size
    * @throws InvalidObjectAttributeType the invalid object attribute type
    */
   public void gameWeek() throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType {

      for(int i = 0; i < 20; i++){
         System.out.println(this.playerTeam.randomContestantStatIncrease(this.difficulty));
         System.out.println(this.playerTeam.randomContestantQuit(this.difficulty).getName());
      }

   }

   /**
    * Gets the player team.
    *
    * @return the player team
    */
   public PlayerTeam getPlayerTeam() {
      return this.playerTeam;
   }

   /**
    * Gets the current week.
    *
    * @return the current week
    */
   public int getCurrentWeek() {
      return this.currentWeek;
   }

   /**
    * Gets the random.
    *
    * @return the random
    */
   public Random getRandom() {
      return this.rnd;
   }

   /**
    * Gets the total weeks.
    *
    * @return the total weeks
    */
   public int getTotalWeeks() {
      return this.totalSeasonWeeks;
   }

   /**
    * Gets the market.
    *
    * @return the market
    */
   public Market getMarket() {
      return this.market;
   }

   /**
    * Sets the market.
    *
    * @throws InvalidObjectAttributeType the invalid object attribute type
    */
   public void setMarket() throws InvalidObjectAttributeType {
      this.market = new Market(this.rnd, this.currentWeek);
   }
   
   /**
    * Gets the stadium.
    *
    * @return the stadium
    */
   public Stadium getStadium() {
      return this.stadium;
   }

   /**
    * Sets the stadium.
    *
    * @throws InvalidObjectAttributeType the invalid object attribute type
    * @throws InvalidTeamSize the invalid team size
    */
   public void setStadium() throws InvalidObjectAttributeType, InvalidTeamSize {
      this.stadium = new Stadium(this.rnd, this.difficulty, this.currentWeek);
   }
   
   /**
    * Launch setup screen.
    */
   public static void launchSetupScreen() {

		SetupScreen setupWindow = new SetupScreen();
	}
   
   /**
    * Close setup screen.
    *
    * @param setupWindow the setup window
    * @throws InvalidObjectAttributeType the invalid object attribute type
    */
   public void closeSetupScreen(SetupScreen setupWindow) throws InvalidObjectAttributeType {
   		game = setupWindow.getGameEnviroment();
		setupWindow.closeWindow();
		launchPlayerSetupScreen();
	}
   
   /**
    * Launch main menu screen.
    */
   public void launchMainMenuScreen() {
		MainMenuScreen mainWindow = new MainMenuScreen(game);
	}
   
   /**
    * Close main menu screen.
    *
    * @param mainWindow the main window
    */
   public void closeMainMenuScreen(MainMenuScreen mainWindow) {
		mainWindow.closeWindow();
	}
   
   /**
    * Launch inventory screen.
    */
   public void launchInventoryScreen() {
   	InventoryScreen inventoryWindow = new InventoryScreen(this);
	}
   
   /**
    * Close inventory screen.
    *
    * @param inventoryWindow the inventory window
    */
   public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
		launchMainMenuScreen();
	}
   
   /**
    * Launch club screen.
    */
   public void launchClubScreen() {
	   ClubScreen clubWindow = new ClubScreen(this);
	}
   
   /**
    * Close club screen.
    *
    * @param clubWindow the club window
    */
   public void closeClubScreen(ClubScreen clubWindow) {
		clubWindow.closeWindow();
		launchMainMenuScreen();
	}
   
   /**
    * Launch store screen.
    */
   public void launchStoreScreen() {
   	StoreScreen storeWindow = new StoreScreen(this);
	}
   
   /**
    * Close store screen.
    *
    * @param storeWindow the store window
    */
   public void closeStoreScreen(StoreScreen storeWindow) {
		storeWindow.closeWindow();
		launchMainMenuScreen();
	}
   
   /**
    * Launch player setup screen.
    *
    * @throws InvalidObjectAttributeType the invalid object attribute type
    */
   public void launchPlayerSetupScreen() throws InvalidObjectAttributeType {
	   PlayerSetupScreen playerSetupWindow = new PlayerSetupScreen(game);
	}
  
   /**
    * Close player setup screen.
    *
    * @param playerSetupWindow the player setup window
    * @throws InvalidObjectAttributeType the invalid object attribute type
    * @throws InvalidTeamSize the invalid team size
    */
   public void closePlayerSetupScreen(PlayerSetupScreen playerSetupWindow) throws InvalidObjectAttributeType, InvalidTeamSize {
	   market = new Market(rnd, 0);
 	   game.setStadium();
	   playerSetupWindow.closeWindow();
	   launchMainMenuScreen();
	}

   /**
    * Launch sled store screen.
    */
   public void launchSledStoreScreen() {

		SledStoreScreen sledStoreWindow = new SledStoreScreen(this);
		
	}

	/**
	 * Launch item store screen.
	 */
	public void launchItemStoreScreen() {
		ItemStoreScreen itemStoreWindow = new ItemStoreScreen(this);
		
	}

	/**
	 * Launch player store screen.
	 */
	public void launchPlayerStoreScreen() {
		PlayerStoreScreen playerStoreWindow = new PlayerStoreScreen(this);
		
	}

	/**
	 * Close item store screen.
	 *
	 * @param itemStoreScreen the item store screen
	 */
	public void closeItemStoreScreen(ItemStoreScreen itemStoreScreen) {
		itemStoreScreen.closeWindow();
		launchStoreScreen();
		
	}

	/**
	 * Close player store screen.
	 *
	 * @param playerStoreScreen the player store screen
	 */
	public void closePlayerStoreScreen(PlayerStoreScreen playerStoreScreen) {
		playerStoreScreen.closeWindow();
		launchStoreScreen();
	}

	/**
	 * Close sled store screen.
	 *
	 * @param sledStoreScreen the sled store screen
	 */
	public void closeSledStoreScreen(SledStoreScreen sledStoreScreen) {
		sledStoreScreen.closeWindow();
		launchStoreScreen();
	}

	/**
	 * Launch stadium screen.
	 */
	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
		}
	   
	/**
	 * Close stadium screen.
	 *
	 * @param stadiumWindow the stadium window
	 */
	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
		launchMainMenuScreen();
		}
  
}

