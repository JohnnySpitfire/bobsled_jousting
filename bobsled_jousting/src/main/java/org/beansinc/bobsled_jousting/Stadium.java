package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class Stadium {

    private ArrayList<ComputerTeam> availableMatches;

    private float difficulty;
    
    public Stadium(Random rnd, float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {

        this.difficulty = difficulty;
        this.availableMatches = new ArrayList<ComputerTeam>();

        int numOfMatches = 3 + rnd.nextInt(3);

        for(int i = 0; i < numOfMatches - 1; i++) {

            ComputerTeam computerTeam = new ComputerTeam("team " + i, rnd, currentWeek);

            this.availableMatches.add(computerTeam);
        }

    }

    public ArrayList<ComputerTeam> getAvalibleMatches() {
        return this.availableMatches;
    } 
    

    public boolean playMatch(PlayerTeam playerTeam, ComputerTeam computerTeam, ArrayList<Item> usedPlayerItems) {

        float matchScore = 0;

        //TODO: Make sure player team is full before calling playMatch()
        if(!playerTeam.isActiveTeamFull()) {
            return false;
        }

        for(Item item: usedPlayerItems){
            

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

            for(ContestantAttribute attr: playerContestantAttr.keySet()) {

                float attrDifference = (playerContestantAttr.get(attr) * this.difficulty) - computerContestantAttr.get(attr);
                matchScore += attrDifference * (1f-this.difficulty);
            }   
        }

        matchScore *= this.difficulty;

        if (matchScore >= 0) {
            return true;
        } else {
            return false;
        }

    }
}
