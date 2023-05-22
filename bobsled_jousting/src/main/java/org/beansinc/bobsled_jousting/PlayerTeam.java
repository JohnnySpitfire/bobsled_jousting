package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTeam.
 */
public class PlayerTeam extends BaseTeam implements TeamBehaviour {

    /** The Constant CONTESTANT_TRAIN_ATTRIBUTE_INCREASE. */
    private static final int CONTESTANT_TRAIN_ATTRIBUTE_INCREASE = 50;

    /** The score. */
    private int score;

    /**
     * Instantiates a new player team.
     *
     * @param name the name
     * @param funds the funds
     * @param random the random
     * @throws InvalidObjectAttributeType the invalid object attribute type
     * @throws InvalidTeamSize the invalid team size
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
     * On week end.
     */
    @Override
    public void onWeekEnd() {

        ArrayList<Contestant> activeTeam = this.getActiveTeam();
        
        for(Contestant contestant : activeTeam){
            
            Contestant modifiedContestant = contestant;
            int maxStanima = contestant.getAttribute(ContestantAttribute.MAX_STANIMA);
            modifiedContestant.editAttribute(ContestantAttribute.STANIMA, maxStanima);
            this.modifyActiveContestant(modifiedContestant, contestant);
        }
        
    }

    /**
     * Swap contestant team.
     *
     * @param contestant the contestant
     * @throws InvalidTeamSize the invalid team size
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
     * Purchase contestant.
     *
     * @param newContestant the new contestant
     * @throws InvalidTeamSize the invalid team size
     */
    @Override
    public void purchaseContestant(Contestant newContestant) throws InvalidTeamSize {
        
        this.addReserveContestant(newContestant);
        this.modifyTotalFunds(-newContestant.getValue());
        
    }

    /**
     * Purchase item.
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
     * Sell contestant.
     *
     * @param asset the asset
     */
    @Override
    public void sellContestant(Contestant asset) {

        if(this.getActiveTeam().contains(asset)){

            try {

                this.removeActiveContestant((Contestant) asset);
                this.modifyTotalFunds(asset.getValue());

            } catch (ContestantNotFound e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (this.getReserveTeam().contains(asset)){

            try {

                this.removeReserveContestant((Contestant) asset);
                this.modifyTotalFunds(asset.getValue());

            } catch(ContestantNotFound | InvalidTeamSize e) {
                // TODO catch_block
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Gets the new random contestant.
     *
     * @param difficulty the difficulty
     * @param currentWeek the current week
     * @return the new random contestant
     * @throws InvalidObjectAttributeType the invalid object attribute type
     * @throws InvalidTeamSize the invalid team size
     */
    @Override
    public Contestant getNewRandomContestant(float difficulty, int currentWeek) throws InvalidObjectAttributeType, InvalidTeamSize {
        
        float newContestantChance = (this.rnd.nextFloat(0.01f, 0.1f)) 
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
     * Random contestant quit.
     *
     * @param difficulty the difficulty
     * @return the contestant
     * @throws ContestantNotFound the contestant not found
     * @throws InvalidTeamSize the invalid team size
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    @Override
    public Contestant randomContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType {

        float contestantQuitChance = (this.rnd.nextFloat(0.01f, 0.5f)) * (1f - difficulty);

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
     * Random contestant stat increase.
     *
     * @param difficulty the difficulty
     * @return the array list
     */
    @Override
    public ArrayList<Contestant[]> randomContestantStatIncrease(float difficulty) {

        ArrayList<Contestant[]> leveledUpContestants = new ArrayList<Contestant[]>();

        for(Contestant oldContestant: this.getActiveTeam()) {

            Contestant modifiedContestant = new Contestant(oldContestant);

            modifiedContestant.getAttributes().forEach((attr, val) -> {

                float contestantStatIncreaseChance = this.rnd.nextFloat(0.1f, 0.3f) * difficulty;
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
     * Train contestant.
     *
     * @param contestant the contestant
     * @return the contestant
     */
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
 