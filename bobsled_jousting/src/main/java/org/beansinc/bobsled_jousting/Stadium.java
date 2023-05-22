package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class Stadium {

    public static final int BASE_STANIMA_LOSS = 50;

    private float fundsRewardFactor;

    private ArrayList<ComputerTeam> availableMatches;

    private float difficulty;
    
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

    public ArrayList<ComputerTeam> getAvailableMatches() {
        return this.availableMatches;
    } 
    //
    //
    //

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

                matchScore += attrDifference * (1f-this.difficulty);
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
