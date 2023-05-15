package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class PlayerTeam extends BaseTeam implements TeamBehaviour {

    public PlayerTeam(String name, int funds) throws InvalidObjectAttributeType, InvalidTeamSize {
        super(name, funds);
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
    public void onContestantPosSwap(Contestant contestant, ContestantPosition newPos) {

        Contestant modifiedContestant = contestant;
        modifiedContestant.setPosition(newPos);
        this.modifyActiveContestant(modifiedContestant, contestant);
    }

    @Override
    public void purchaseActivePlayer(Contestant newContestant) throws InvalidTeamSize {
        
        this.addActiveContestant(newContestant);
        this.modifyTotalFunds(-newContestant.getValue());
        
    }

    @Override
    public void purchaseReservePlayer(Contestant newContestant) throws InvalidTeamSize{

        this.addReserveContestant(newContestant);
        this.modifyTotalFunds(-newContestant.getValue());
    }

    @Override
    public void onItemPurchase(Item item, int cost) {
        this.modifyTotalFunds(-item.value);
        this.addItem(item);
    }

    @Override
    public void getNewRandomContestant(Contestant newContestant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNewRandomAthlete'");
    }

    @Override
    public void onSellAsset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSellAsset'");
    }

    @Override
    public void onContestantQuit(Contestant contestant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onContestantQuit'");
    }

    @Override
    public void onAthleteStatIncrease(Contestant contestant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onAthleteStatIncrease'");
    }

}
 