package org.beansinc.bobsled_jousting;

import java.util.ArrayList;
import java.util.Random;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class PlayerTeam extends BaseTeam implements TeamBehaviour {

    private int score;

    public PlayerTeam(String name, int funds, Random random) throws InvalidObjectAttributeType, InvalidTeamSize {
        super(name, funds, random);
    }

    public int getScore() {
        return this.score;
    }

    public void modifyScore(int difference) {
        this.score += difference;
    } 

    @Override
    public void onWeekEnd() {

        ArrayList<Contestant> activeTeam = this.getActiveTeam();
        
        for(Contestant contestant : activeTeam){
            
            Contestant modifiedContestant = contestant;
            modifiedContestant.editStat(ContestantAttribute.STANIMA, 100);
            this.modifyActiveContestant(modifiedContestant, contestant);
        }
    }

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

    @Override
    public void purchaseContestant(Contestant newContestant) throws InvalidTeamSize {
        
        this.addReserveContestant(newContestant);
        this.modifyTotalFunds(-newContestant.getValue());
        
    }

    @Override
    public void purchaseItem(Item item, int cost) {
        this.modifyTotalFunds(-item.value);
        this.addItem(item);
    }

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

    @Override
    public Contestant onContestantQuit(float difficulty) throws ContestantNotFound, InvalidTeamSize, InvalidObjectAttributeType {

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

    @Override
    public ArrayList<Contestant[]> onAthleteStatIncrease(float difficulty) {

        ArrayList<Contestant[]> leveledUpContestants = new ArrayList<Contestant[]>();

        for(Contestant oldContestant: this.getActiveTeam()) {

            Contestant modifiedContestant = new Contestant(oldContestant);

            modifiedContestant.getAttributes().forEach((attr, val) -> {

                float contestantStatIncreaseChance = this.rnd.nextFloat(0.1f, 0.3f) * difficulty;
                int contestantStatIncrease = 10 + this.rnd.nextInt(20);

                    if(contestantStatIncreaseChance > 0.17) {

                        val += contestantStatIncrease;
                        modifiedContestant.editStat(attr, val);
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

}
 