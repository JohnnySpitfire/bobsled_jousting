package org.beansinc.bobsled_jousting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class StadiumTest {
    
    Stadium testStadium;
    PlayerTeam playerTeam;
    ComputerTeam computerTeam;

    ArrayList<Item> usedPlayerItems;

    float difficulty;

    @BeforeEach
    void initalize() throws InvalidObjectAttributeType, InvalidTeamSize {

        Random rnd = new Random();
        this.difficulty = rnd.nextFloat();
        int currentWeek = rnd.nextInt(14);

        usedPlayerItems = new ArrayList<Item>();

        this.testStadium = new Stadium(rnd, difficulty, currentWeek);
        this.playerTeam = new PlayerTeam("test", 0, rnd);

        for (int i = 0 ; i < BaseTeam.MAX_ACTIVE_SIZE; i++) {
            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.playerTeam.addActiveContestant(newContestant);
        }

        int rndComputerTeamIndex = rnd.nextInt(this.testStadium.getAvailableMatches().size());
        this.computerTeam = this.testStadium.getAvailableMatches().get(rndComputerTeamIndex);
    }

    @RepeatedTest(2000)
    @Test
    void testPlayMatch() {

        float matchScore = 0;

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

            for(ContestantAttribute attr: attrKeys) {

                if(attr == ContestantAttribute.STANIMA || attr == ContestantAttribute.MAX_STANIMA) {
                    continue;
                }

                float attrDifference = (playerContestantAttr.get(attr) * this.difficulty) - computerContestantAttr.get(attr);

                if(attrDifference < 0) {
                    
                }
                matchScore += attrDifference * (1f-this.difficulty);
            }

            int oldStanimaVal = activeComputerTeam.get(i).getAttribute(ContestantAttribute.STANIMA);

            activeComputerTeam.get(i).editAttribute(ContestantAttribute.STANIMA, oldStanimaVal - Stadium.BASE_STANIMA_LOSS);

            if(activePlayerTeam.get(i).getAttribute(ContestantAttribute.STANIMA) >= 0) {

                activeComputerTeam.get(i).addModifier(ContestantModifer.INJURED);

            }
        }

        matchScore *= this.difficulty;
        boolean playerWon = this.testStadium.playMatch(playerTeam, computerTeam, new ArrayList<Item>());

        if (matchScore >= 0) {
            assertTrue(playerWon);
        } else {
            assertFalse(playerWon);
        }

    }

}
