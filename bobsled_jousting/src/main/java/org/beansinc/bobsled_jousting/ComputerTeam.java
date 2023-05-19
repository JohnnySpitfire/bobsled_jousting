package org.beansinc.bobsled_jousting;

import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class ComputerTeam extends BaseTeam {
    
    public ComputerTeam(String name, Random rnd, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {

        super(name, rnd);
        this.swapSled(Utils.generateRandomSled(rnd, currentWeek));
        this.generateActiveTeam(currentWeek);
        
    }

    private void generateActiveTeam(int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize{
        
        for(int i = 0; i < MAX_ACTIVE_SIZE; i++){

            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.addActiveContestant(newContestant);
            
        }
    }

    public void applyPlayerItem(Item item) {

        
    }
}
