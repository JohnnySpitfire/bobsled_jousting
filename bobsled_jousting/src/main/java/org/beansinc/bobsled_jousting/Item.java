package org.beansinc.bobsled_jousting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Item {
    
    ATTACK_POTION(50, "Permamently increases a contestants offence by 20", true , true),
    DEFENCE_POTION(50, "Permamently increases a contestants defence by 20", true, true),
    STANIMA_POTION(50, "Permamently increases a contestants stanima by 20", true, true),
    HEALTH_POTION(200, "Heals a player; removing the INJURED modifier" ,true, true),

    SLIME_BOMB(100, "Slimes an enemy sled decreasing their offence and reducing their sled's speed by 40", false, false);


    public final int value;
    public final String description;
    public final boolean appliesToPlayerTeam;
    public final boolean appliesToContestant;

    Item(int value, String description, boolean appliesToPlayerTeam, boolean appliesToContestant){
        this.value = value;
        this.description = description;
        this.appliesToPlayerTeam = appliesToPlayerTeam;
        this.appliesToContestant = appliesToContestant;
    }

    public static final List<Item> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static Item getRandomItem(Random rnd) {
         
        return VALUES.get(rnd.nextInt(VALUES.size()));
    }

    public static void applyItemToTeam(BaseTeam team, Item item) {

        switch(item) {

            case SLIME_BOMB:

                Sled modifiedSled = team.getSled();
                modifiedSled.addModifier(SledModifier.SLIME);
                modifiedSled.editAttribute(SledAttribute.SPEED, modifiedSled.getAttribute(SledAttribute.SPEED) - 40);

                for(Contestant contestant : team.getActiveTeam()) {

                    contestant.editAttribute(ContestantAttribute.OFFENCE, contestant.getAttribute(ContestantAttribute.OFFENCE) - 40);
                }
                break;

            default:
                break;

        }
    }

    public static void applyItemToContestant(Contestant contestant, Item item) {

        switch(item) {

            case HEALTH_POTION:
                contestant.removeModifier(ContestantModifer.INJURED);

            case ATTACK_POTION:
                int currentOffenceVal = contestant.getAttribute(ContestantAttribute.OFFENCE);
                contestant.editAttribute(ContestantAttribute.OFFENCE, currentOffenceVal + 20);
                contestant.updateValue();
                break;

            case DEFENCE_POTION:
                int currentDefenceVal = contestant.getAttribute(ContestantAttribute.DEFENCE);
                contestant.editAttribute(ContestantAttribute.DEFENCE, currentDefenceVal + 20);
                contestant.updateValue();
                break;

            case STANIMA_POTION:
                int currentStanimaVal = contestant.getAttribute(ContestantAttribute.MAX_STANIMA);
                contestant.editAttribute(ContestantAttribute.MAX_STANIMA, currentStanimaVal + 20);
                contestant.updateValue();
                break;

            default:
                break;
        }
    }

    
}
