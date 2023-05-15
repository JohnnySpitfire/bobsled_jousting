package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Scanner;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scn = new Scanner(System.in);
        try {

            gameSetUp(scn);

            
        
            scn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void gameSetUp(Scanner scn) throws InvalidObjectAttributeType, InvalidTeamSize {
        System.out.println("Please enter a team name");
        String teamName = scn.nextLine();
        System.out.println("How many weeks would you like to play?");
        int totalWeeks = scn.nextInt();
        System.out.println("Please enter a difficulty (0 to 100)");
        int difficulty = scn.nextInt();

        GameEnviroment game = new GameEnviroment(teamName, totalWeeks, difficulty);

        int funds = game.getPlayerTeam().getTotalFunds();

        System.out.println("You have $" + funds);
        System.out.println("Select active contestants:");

        ArrayList<Contestant> initalContestants = new ArrayList<Contestant>();
        ArrayList<Contestant> startingActiveContestants = new ArrayList<Contestant>();
        ArrayList<Contestant> startingReserveContestants = new ArrayList<Contestant>();


        for(int i=0; i<=15; i++){

            Contestant randContestant = game.generateRandomContestant();
            initalContestants.add(randContestant);

            System.out.println(String.format("%s. %s", i + 1, randContestant.getName()));
            System.out.println(String.format("    %s", randContestant.getPosition()));
            System.out.println(String.format("    %s", randContestant.getAttributes()));
            System.out.println(String.format("    $%s", randContestant.getValue()));

        }

        int i = 0;
        do {

            System.out.println(String.format("Enter a number to buy (%s remaining)", 4-i));
            System.out.println(String.format("You have $%s", funds));
            int buyIndex = scn.nextInt() - 1;

            if (startingActiveContestants.contains(initalContestants.get(buyIndex))){
                System.out.println("Please select another contestant");
                continue;
            }
            startingActiveContestants.add(initalContestants.get(buyIndex));
            funds -= initalContestants.get(buyIndex).getValue();
            i++;
        } while (i < 4);

        System.out.println("Select reserve contestants:");

        i = 0;
        do {

            System.out.println(String.format("Enter a number to buy (%s remaining)", 4-i));
            System.out.println(String.format("You have $%s", funds));
            int buyIndex = scn.nextInt() - 1;

            if (startingReserveContestants.contains(initalContestants.get(buyIndex))){
                System.out.println("Please select another contestant");
                continue;
            }
            funds -= initalContestants.get(buyIndex).getValue();
            startingReserveContestants.add(initalContestants.get(buyIndex));
            i++;
        } while (i < 4);

        game.gameStart(startingActiveContestants, startingReserveContestants);
    }
}
