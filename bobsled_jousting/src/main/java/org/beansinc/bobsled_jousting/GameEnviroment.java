package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class GameEnviroment {

   private int totalSeasonWeeks;
   private int currentWeek;

   private float difficulty;

   private PlayerTeam playerTeam;
   private GameEnviroment game;

   Market market;
   Stadium stadium;
   
   private boolean playedMatch;
   private boolean matchOutcome;

   Random rnd;

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

   public void gameStart(ArrayList<Contestant> activeContestants, ArrayList<Contestant> reserveContestants) throws InvalidTeamSize {

      for(Contestant contestant : activeContestants) {
         this.playerTeam.addActiveContestant(contestant);
      }

      for(Contestant contestant : reserveContestants) {
         this.playerTeam.addReserveContestant(contestant);
      }

   }

   public void gameWeek() throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType {

      for(int i = 0; i < 20; i++){
         System.out.println(this.playerTeam.randomContestantStatIncrease(this.difficulty));
         System.out.println(this.playerTeam.randomContestantQuit(this.difficulty).getName());
      }

   }

   public PlayerTeam getPlayerTeam() {
      return this.playerTeam;
   }

   public int getCurrentWeek() {
      return this.currentWeek;
   }

   public Random getRandom() {
      return this.rnd;
   }

   public int getTotalWeeks() {
      return this.totalSeasonWeeks;
   }

   public Market getMarket() {
      return this.market;
   }

   public void setMarket() throws InvalidObjectAttributeType {
      this.market = new Market(this.rnd, this.currentWeek);
   }
   
   public Stadium getStadium() {
      return this.stadium;
   }

   public void setStadium() throws InvalidObjectAttributeType, InvalidTeamSize {
      this.stadium = new Stadium(this.rnd, this.difficulty, this.currentWeek);
   }
   
   public boolean getPlayedMatch() {
		return playedMatch;
	}

	public void setPlayedMatch(boolean playedMatch) {
		this.playedMatch = playedMatch;
	}
	
	public boolean getMatchOutcome() {
		return this.matchOutcome;
	}

	public void setMatchOutcome(boolean matchOutcome) {
		this.matchOutcome = matchOutcome;
	}
	
	public void addWeek() {
		this.currentWeek += 1;
	}
	
	public float getDifficulty() {
		return this.difficulty;
	}
   
   public static void launchSetupScreen() {

		SetupScreen setupWindow = new SetupScreen();
	}
   
   public void closeSetupScreen(SetupScreen setupWindow) throws InvalidObjectAttributeType {
   		game = setupWindow.getGameEnviroment();
		setupWindow.closeWindow();
		launchPlayerSetupScreen();
	}
   
   public void launchMainMenuScreen() {
		MainMenuScreen mainWindow = new MainMenuScreen(game);
	}
   
   public void closeMainMenuScreen(MainMenuScreen mainWindow) {
		mainWindow.closeWindow();
	}
   
   public void launchInventoryScreen() {
   	InventoryScreen inventoryWindow = new InventoryScreen(this);
	}
   
   public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
		launchMainMenuScreen();
	}
   
   public void launchClubScreen() {
	   ClubScreen clubWindow = new ClubScreen(this);
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
   
   public void launchPlayerSetupScreen() throws InvalidObjectAttributeType {
	   PlayerSetupScreen playerSetupWindow = new PlayerSetupScreen(game);
	}
  
   public void closePlayerSetupScreen(PlayerSetupScreen playerSetupWindow) throws InvalidObjectAttributeType, InvalidTeamSize {
	   market = new Market(rnd, 0);
 	   game.setStadium();
	   playerSetupWindow.closeWindow();
	   launchMainMenuScreen();
	}

   public void launchSledStoreScreen() {

		SledStoreScreen sledStoreWindow = new SledStoreScreen(this);
		
	}

	public void launchItemStoreScreen() {
		ItemStoreScreen itemStoreWindow = new ItemStoreScreen(this);
		
	}

	public void launchPlayerStoreScreen() {
		PlayerStoreScreen playerStoreWindow = new PlayerStoreScreen(this);
		
	}

	public void closeItemStoreScreen(ItemStoreScreen itemStoreScreen) {
		itemStoreScreen.closeWindow();
		launchStoreScreen();
		
	}

	public void closePlayerStoreScreen(PlayerStoreScreen playerStoreScreen) {
		playerStoreScreen.closeWindow();
		launchStoreScreen();
	}

	public void closeSledStoreScreen(SledStoreScreen sledStoreScreen) {
		sledStoreScreen.closeWindow();
		launchStoreScreen();
	}

	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
		}
	   
	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
		launchMainMenuScreen();
		}
	
	public void afterMatchWindow(StadiumScreen stadiumScreen) throws InvalidObjectAttributeType, InvalidTeamSize {
		stadiumScreen.closeWindow();
		launchPostWeekScreen();
	}
	
	public void launchPostWeekScreen() throws InvalidObjectAttributeType, InvalidTeamSize {
		PostWeekScreen postWeekWindow = new PostWeekScreen(this);
		game.setMarket();
		game.setStadium();
		}
	   
	public void closePostWeekScreen(PostWeekScreen postWeekWindow) throws InvalidObjectAttributeType {
		
		game.addWeek();
		int playersToFullTeam = 4 - (game.getPlayerTeam().getActiveTeam().size() + game.getPlayerTeam().getReserveTeam().size());

		if (game.getCurrentWeek() <= game.getTotalWeeks()) {
			if (playersToFullTeam < 1) {
				launchMainMenuScreen();
			}else {
				ArrayList<Integer> cheapestPlayers = new ArrayList<Integer>();
				for(int i = 0; i < game.getMarket().getContestantSaleArray().size(); i++) {
					cheapestPlayers.add(game.getMarket().getContestantSaleArray().get(i).getValue());
				}
				Collections.sort(cheapestPlayers);
				int sum = 0;
				for(int i = 0; i < playersToFullTeam; i++) {
					sum += cheapestPlayers.get(i);
				}
				if (cheapestPlayers.size() > playersToFullTeam && sum < game.getPlayerTeam().getTotalFunds()) {
					launchMainMenuScreen();
				}else {
					launchEndScreen();
				}
			}
		}else {
			launchEndScreen();
		}
		postWeekWindow.closeWindow();
		}
	
	public void launchEndScreen() throws InvalidObjectAttributeType {
		EndScreen endWindow = new EndScreen(this);
	}

	public void closeEndScreen(EndScreen endWindow) {
		endWindow.closeWindow();
		}
}

