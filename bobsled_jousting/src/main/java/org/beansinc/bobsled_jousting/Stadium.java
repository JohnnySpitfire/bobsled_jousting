package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

// TODO: Auto-generated Javadoc
/**
 * This class controls the matches avalible to the player, as well as the behaviour of the matches themselves.
 */
public class Stadium {

    /** The base amount of stanima lost on each game. */
    public static final int BASE_STANIMA_LOSS = 100;

    /** The funds reward factor. */
    private float fundsRewardFactor;

    /** The available matches. */
    private ArrayList<ComputerTeam> availableMatches;

    /** The difficulty. */
    private float difficulty;
    
    /**
     * Instantiates a new stadium.
     *
     * @param rnd the Random object from GameEnviroment
     * @param difficulty the difficulty of the game
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    public Stadium(Random rnd, float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {

        this.difficulty = difficulty;
        this.fundsRewardFactor = 3 * (1f - difficulty);
        this.availableMatches = new ArrayList<ComputerTeam>();

        int numOfMatches = 3 + rnd.nextInt(3);

        for(int i = 0; i < numOfMatches - 1; i++) {

            ComputerTeam computerTeam = new ComputerTeam("team " + i, rnd, currentWeek);

            this.availableMatches.add(computerTeam);
        }

    }

    
    /** 
     * @return ArrayList<ComputerTeam>
     */
    public ArrayList<ComputerTeam> getAvailableMatches() {
        return this.availableMatches;
    } 
    
    /**
     *  Plays a match between the player and a generated computer team.
     *  The match compares the offence and defence attributes of the players of the two teams and compares them.
     *  The difference is then modified by a difficulty factor, and subtracted from the players stanima.
     *  The score is then modified by the difficulty again, and added to the players team.
     * 
     *
     * @param playerTeam the player team
     * @param computerTeam the computer team
     * @param usedPlayerItems Items which the player has used (Must only apply to teams, individual items are applied in the club screen)
     * @return boolean Whether the player has won or lost the match (True if they won, False if they lost)
     */

    public boolean playMatch(PlayerTeam playerTeam, ComputerTeam computerTeam, ArrayList<Item> usedPlayerItems) {

        float matchScore = 0;

        if(!playerTeam.isActiveTeamFull()) {
            return false;
        }

        for(Item item: usedPlayerItems){
            
            if(item.appliesToPlayerTeam){
                Item.applyItemToTeam(playerTeam, item);
            } else {
                Item.applyItemToTeam(computerTeam, item);
            }
        }

        ArrayList<Contestant> activePlayerTeam = playerTeam.getActiveTeam();
        ArrayList<Contestant> activeComputerTeam = computerTeam.getActiveTeam();

        Map<SledAttribute, Integer> playerSledAttributes = playerTeam.getSled().getAttributes();
        Map<SledAttribute, Integer> computerSledAttributes = computerTeam.getSled().getAttributes();

        for (SledAttribute attr: playerSledAttributes.keySet()){

            float attrDifference = (playerSledAttributes.get(attr) * this.difficulty) - computerSledAttributes.get(attr);
            matchScore += attrDifference * (1f-this.difficulty);
        }

        for(int i = 0; i < BaseTeam.MAX_ACTIVE_SIZE; i++){

            Map<ContestantAttribute, Integer> playerContestantAttr = activePlayerTeam.get(i).getAttributes();
            Map<ContestantAttribute, Integer> computerContestantAttr = activeComputerTeam.get(i).getAttributes();

            Set<ContestantAttribute> attrKeys = playerContestantAttr.keySet();

            int modifiedStanimaVal = activeComputerTeam.get(i).getAttribute(ContestantAttribute.STANIMA);

            for(ContestantAttribute attr: attrKeys) {

                if(attr == ContestantAttribute.STANIMA || attr == ContestantAttribute.MAX_STANIMA) {
                    break;
                }

                float attrDifference = (playerContestantAttr.get(attr) * this.difficulty) - computerContestantAttr.get(attr);

                if(attrDifference < 0) {
                    modifiedStanimaVal -= attrDifference;
                }

                matchScore += attrDifference * this.difficulty;
            }

            activeComputerTeam.get(i).editAttribute(ContestantAttribute.STANIMA, modifiedStanimaVal - BASE_STANIMA_LOSS);

            if(activePlayerTeam.get(i).getAttribute(ContestantAttribute.STANIMA) >= 0) {

                activeComputerTeam.get(i).addModifier(ContestantModifer.INJURED);

            }
        }

        matchScore *= this.difficulty;
        playerTeam.modifyTotalFunds((int) (matchScore * fundsRewardFactor));


        if (matchScore >= 0) {
            return true;
        } else {
            return false;
        }

    }
}
