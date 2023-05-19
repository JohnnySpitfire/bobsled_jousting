package org.beansinc.bobsled_jousting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class StadiumTest {
    
    Stadium testStadium;
    PlayerTeam playerTeam;
    ComputerTeam computerTeam;

    float difficulty;

    @BeforeEach
    void initalize() throws InvalidObjectAttributeType, InvalidTeamSize {

        Random rnd = new Random();
        this.difficulty = rnd.nextFloat();
        int currentWeek = rnd.nextInt(14);

        this.testStadium = new Stadium(rnd, difficulty, currentWeek);
        this.playerTeam = new PlayerTeam("test", 0, rnd);

        for (int i = 0 ; i < BaseTeam.MAX_ACTIVE_SIZE; i++) {
            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.playerTeam.addActiveContestant(newContestant);
        }

        int rndComputerTeamIndex = rnd.nextInt(this.testStadium.getAvalibleMatches().size());
        this.computerTeam = this.testStadium.getAvalibleMatches().get(rndComputerTeamIndex);
    }

    @RepeatedTest(2000)
    @Test
    void testPlayMatch() {

        float matchScore = 0;

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
        boolean playerWon = testStadium.playMatch(this.playerTeam, this.computerTeam, new ArrayList<Item>());
        

        if (matchScore >= 0) {
            assertTrue(playerWon);
        } else {
            assertFalse(playerWon);
        }

    }

}
