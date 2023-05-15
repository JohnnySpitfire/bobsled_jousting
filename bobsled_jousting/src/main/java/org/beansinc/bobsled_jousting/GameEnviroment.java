package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class GameEnviroment {

   private static int MIN_RANDOM_ATTRIBUTE = 50;
   private static int MAX_RANDOM_ATTRIBUTE= 200;

   private static int CONTESTANT_BASE_VALUE = 50;
   private static int CONTESTANT_ATTRIBUTE_VALUE_FACTOR = 8;

   private int totalSeasonWeeks;
   private int currentWeek;

   private float difficulty;

   private PlayerTeam playerTeam;

   Random rnd;

   public GameEnviroment(String teamName, int totalWeeks, int difficulty) {

      this.totalSeasonWeeks = totalWeeks;
      this.difficulty = (float) (difficulty)/100f;

      int startingFunds = (int) (2000 - 1000 * this.difficulty);

      try {
         this.playerTeam = new PlayerTeam(teamName, startingFunds);
      } catch (InvalidObjectAttributeType e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (InvalidTeamSize e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      this.rnd = new Random();
      
   }

   public void gameStart(ArrayList<Contestant> activeContestants, ArrayList<Contestant> reserveContestants) throws InvalidTeamSize {

      for(Contestant contestant : activeContestants) {
         this.playerTeam.addActiveContestant(contestant);
      }

      for(Contestant contestant : reserveContestants) {
         this.playerTeam.addReserveContestant(contestant);
      }

   }

   public void gameWeek(){

   }

   public PlayerTeam getPlayerTeam() {
      return this.playerTeam;
   }

   public int getCurrentWeek() {
      return this.currentWeek;
   }

   public int getTotalWeeks() {
      return this.totalSeasonWeeks;
   }

   public Contestant generateRandomContestant() throws InvalidObjectAttributeType {


      String[] contestantNames = {"Steve", "Elliot", "Jim", "Finn", "Lisa", "Emily", "Flynn", "Zoe", "Jamie", "Ryan", "Hamish", "Will", "Ben"};
      
      String randomName = contestantNames[rnd.nextInt(contestantNames.length - 1)];
      ContestantPosition randomPosition = ContestantPosition.getRandomModifer(rnd);

      Object[][] randomAttributes = ContestantAttribute.getDefaultAttributes();

      int value = CONTESTANT_BASE_VALUE;

      for(Object[] attr : randomAttributes){
         int attributeVal = MIN_RANDOM_ATTRIBUTE + rnd.nextInt(MAX_RANDOM_ATTRIBUTE - MIN_RANDOM_ATTRIBUTE);
         
         value += CONTESTANT_BASE_VALUE + attributeVal / CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
         attr[1] = attributeVal;

      }

      Contestant randomContestant = new Contestant(randomName, randomPosition, randomAttributes, value);
      
      return randomContestant;
   }
   
}

