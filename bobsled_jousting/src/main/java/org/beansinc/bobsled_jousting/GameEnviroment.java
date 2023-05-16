package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class GameEnviroment {

   private int totalSeasonWeeks;
   private int currentWeek;

   private float difficulty;

   private PlayerTeam playerTeam;
   

   Random rnd;

   public GameEnviroment(String teamName, int totalWeeks, int difficulty) {

      this.rnd = new Random();
      this.totalSeasonWeeks = totalWeeks;
      this.difficulty = 1f - (float) (difficulty)/100f;

      int startingFunds = (int) (3000 - 1000 * this.difficulty);

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
         System.out.println(this.playerTeam.onAthleteStatIncrease(this.difficulty));
         System.out.println(this.playerTeam.onContestantQuit(this.difficulty).getName());
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
   
}

