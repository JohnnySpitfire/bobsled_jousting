package org.beansinc.bobsled_jousting;

import java.util.ArrayList;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

public class PlayerTeam extends BaseTeam implements TeamBehaviour {

    public PlayerTeam(String name) throws InvalidTeamSize {
        super(name, new ArrayList<Contestant>(), new ArrayList<Contestant>());
    }

    @Override
    public void onWeekEnd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onWeekEnd'");
    }

    @Override
    public void onMatchPlay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMatchPlay'");
    }

    @Override
    public void onContestantPosSwap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onContestantPosSwap'");
    }

    @Override
    public void onContestantTransfer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onContestantTransfer'");
    }

    @Override
    public void onItemPurchase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onItemPurchase'");
    }

    @Override
    public void getNewRandomAthlete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNewRandomAthlete'");
    }

    @Override
    public void onSellAsset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSellAsset'");
    }
    
}
 