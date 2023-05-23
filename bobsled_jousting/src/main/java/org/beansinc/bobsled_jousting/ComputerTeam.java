package org.beansinc.bobsled_jousting;

import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

/**
 * Creates a new computer team for the matches.
 */
public class ComputerTeam extends BaseTeam {
    
    /**
     * Instantiates a new computer team.
     *
     * @param name the name
     * @param rnd the Random object from GameEnviroment
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    public ComputerTeam(String name, Random rnd, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {

        super(name, rnd);
        this.swapSled(Utils.generateRandomSled(rnd, currentWeek));
        this.generateActiveTeam(currentWeek);
        
    }

    
    /**
     *  Generates a new active team for the computer
     *
     * @param currentWeek the current week
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    private void generateActiveTeam(int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize{
        
        for(int i = 0; i < MAX_ACTIVE_SIZE; i++){

            Contestant newContestant = Utils.generateRandomContestant(rnd, currentWeek);
            this.addActiveContestant(newContestant);
            
        }
    }
}
