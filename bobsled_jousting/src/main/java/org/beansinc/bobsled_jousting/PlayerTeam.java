package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

/**
 * This class provides the behaviour necessary for the player to control their team.
 * Much of the GUI's behavior is dependent on this class.
 */
public class PlayerTeam extends BaseTeam implements TeamBehaviour {

    /** The amount that the stats are increases when a contestant is trained. */
    private static final int CONTESTANT_TRAIN_ATTRIBUTE_INCREASE = 50;

    /** The player's score. */
    private int score;

    /**
     * Instantiates a new player team.
     *
     * @param name the name of the team
     * @param funds the starting funds of the team
     * @param random the random object from GameEnviroment
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    public PlayerTeam(String name, int funds, Random random) throws InvalidObjectAttributeType, InvalidTeamSize {
        super(name, funds, random);
    }

    
    /** 
     * @return int
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Modify score.
     *
     * @param difference the difference
     */
    public void modifyScore(int difference) {
        this.score += difference;
    } 

    /**
     * Methods to run at the end of the week.
     */
    @Override
    public void onWeekEnd() {

        ArrayList<Contestant> activeTeam = this.getActiveTeam();
        
        for(Contestant contestant : activeTeam){
            
            Contestant modifiedContestant = contestant;
            int maxStanima = contestant.getAttribute(ContestantAttribute.MAX_STANIMA);
            modifiedContestant.editAttribute(ContestantAttribute.STANIMA, maxStanima);
            
            if(modifiedContestant.getModifiers().contains(ContestantModifer.INJURED)) {
                modifiedContestant.removeModifier(ContestantModifer.INJURED);
            }

            this.modifyActiveContestant(modifiedContestant, contestant);
        }
        
    }

    /**
     * Swaps contestant between the active and reserve teams.
     *
     * @param contestant the contestant to be swapped
     * @throws InvalidTeamSize
     */
    @Override
    public void swapContestantTeam(Contestant contestant) throws InvalidTeamSize {

        if (this.getActiveTeam().contains(contestant)) {

            this.removeActiveContestant(contestant);
            this.addReserveContestant(contestant);

        } else if (this.getReserveTeam().contains(contestant)) {

            this.removeReserveContestant(contestant);
            this.addActiveContestant(contestant);
            
        }
    }

    /**
     * Adds a contestant to the reserve team.
     *
     * @param contestant the contestant to be added
     * @throws InvalidTeamSize
     */
    @Override
    public void addContestant(Contestant newContestant) throws InvalidTeamSize {
        
        this.addReserveContestant(newContestant);
        this.modifyTotalFunds(-newContestant.getValue());
        
    }

    /**
     * Purchase an item.
     *
     * @param item the item
     * @param cost the cost
     */
    @Override
    public void purchaseItem(Item item, int cost) {
        this.modifyTotalFunds(-item.value);
        this.addItem(item);
    }

    /**
     * Sells a contestant.
     *
     * @param contestant the contestant to be sold
     */
    @Override
    public void sellContestant(Contestant asset) {

        if(this.getActiveTeam().contains(asset)){

            try {

                this.removeActiveContestant((Contestant) asset);
                this.modifyTotalFunds(asset.getValue());

            } catch (ContestantNotFound e) {
                e.printStackTrace();
            }
        } else if (this.getReserveTeam().contains(asset)){

            try {

                this.removeReserveContestant((Contestant) asset);
                this.modifyTotalFunds(asset.getValue());

            } catch(ContestantNotFound | InvalidTeamSize e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Gets the new random contestant.
     *
     * @param difficulty the difficulty of the game
     * @param currentWeek the current week
     * @return Contestant the new random contestant
     * @throws InvalidObjectAttributeType
     * @throws InvalidTeamSize
     */
    @Override
    public Contestant getNewRandomContestant(float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {
        
        float newContestantChance = (this.rnd.nextFloat() * 0.1f )
                                    * MAX_RESERVE_SIZE - this.getReserveTeam().size()
                                    * difficulty;
        
        if(newContestantChance > 0.1) {

            Contestant newContestant = Utils.generateRandomContestant(this.rnd, currentWeek);
            this.addReserveContestant(newContestant);
            return newContestant;
        }
        return new Contestant("null");
    }

    /**
     * Checks if a random contestant quit. If they quit they get removed from the team.
     *
     * @param difficulty the difficulty
     * @return Contestant If the a contestant quit, then that contestant would be returned. Otherwise, a new contestant with the name "null" will be returned.
     * @throws ContestantNotFound the contestant not found
     * @throws InvalidTeamSize the invalid team size
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    @Override
    public Contestant randomContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType {

        float contestantQuitChance = (this.rnd.nextFloat()) * (1f - difficulty) * 0.5f;

        for(Contestant contestant : this.getActiveTeam()) {

            if(contestant.getModifiers().contains(ContestantModifer.INJURED)) { 
                contestantQuitChance += 0.1f;
            }

            if (contestantQuitChance > 0.2f) {
                this.removeActiveContestant(contestant);
                return contestant;
            }

        }
        return new Contestant("null");
    }

    /**
     * Randomly increases the stats of selected contestants.
     *
     * @param difficulty the difficulty
     * @return ArrayList<Contestant[]> An ArrayList of {Upgraded Contestant, Old contestant} pairs. Not upgraded contestants are not included.
     */
    @Override
    public ArrayList<Contestant[]> randomContestantStatIncrease(float difficulty) {

        ArrayList<Contestant[]> leveledUpContestants = new ArrayList<Contestant[]>();

        for(Contestant oldContestant: this.getActiveTeam()) {

            Contestant modifiedContestant = new Contestant(oldContestant);

            modifiedContestant.getAttributes().forEach((attr, val) -> {

                float contestantStatIncreaseChance = this.rnd.nextFloat() * difficulty * 0.2f;
                int contestantStatIncrease = 10 + this.rnd.nextInt(20);

                    if(contestantStatIncreaseChance > 0.17) {

                        val += contestantStatIncrease;
                        modifiedContestant.editAttribute(attr, val);
                    }
                
            });

            modifiedContestant.updateValue();

            boolean isNotModified = modifiedContestant.getAttributes().entrySet().stream().noneMatch(
                entry -> 
                    oldContestant.getAttribute(entry.getKey()) != entry.getValue()
                );

            if(!isNotModified){
                this.modifyActiveContestant(modifiedContestant, oldContestant);
                leveledUpContestants.add(new Contestant[]{modifiedContestant, oldContestant});
            }
   
        }

        return leveledUpContestants;
       
    }

    /**
     * Trains a contestant.
     *
     * @param contestant the contestant to be trained
     * @return Contestant - the newly trained contestant
     */
    @Override
    public Contestant trainContestant(Contestant contestant) {

        int oldOffenceVal = contestant.getAttribute(ContestantAttribute.OFFENCE);
        int oldDefenceVal = contestant.getAttribute(ContestantAttribute.DEFENCE);
        int oldMaxStanimaVal = contestant.getAttribute(ContestantAttribute.MAX_STANIMA);

        contestant.editAttribute(ContestantAttribute.OFFENCE, oldOffenceVal + CONTESTANT_TRAIN_ATTRIBUTE_INCREASE);
        contestant.editAttribute(ContestantAttribute.DEFENCE, oldDefenceVal + CONTESTANT_TRAIN_ATTRIBUTE_INCREASE);
        contestant.editAttribute(ContestantAttribute.MAX_STANIMA, oldMaxStanimaVal + CONTESTANT_TRAIN_ATTRIBUTE_INCREASE);

        return contestant;

    }

}
 