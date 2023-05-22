package org.beansinc.bobsled_jousting;

import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

// TODO: Auto-generated Javadoc
/**
 * The Class ComputerTeam.
 */
public class ComputerTeam extends BaseTeam {
    
    /**
     * Instantiates a new computer team.
     *
     * @param name the name
     * @param rnd the rnd
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType the invalid object attribute type
     * @throws InvalidTeamSize the invalid team size
     */
    public ComputerTeam(String name, Random rnd, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {

        super(name, rnd);
        this.swapSled(Utils.generateRandomSled(rnd, currentWeek));
        this.generateActiveTeam(currentWeek);
        
    }

    
    /**
     *  
     *
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType the invalid object attribute type
     * @throws InvalidTeamSize the invalid team size
     */
    private void generateActiveTeam(int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize{
        
        for(int i = 0; i < MAX_ACTIVE_SIZE; i++){

            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.addActiveContestant(newContestant);
            
        }
    }

    /**
     * Apply player item.
     *
     * @param item the item
     */
    public void applyPlayerItem(Item item) {

        
    }
}
