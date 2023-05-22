package org.beansinc.bobsled_jousting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class TeamMemberTest {

    TeamMember<ContestantAttribute, ContestantModifer> contestant;
    TeamMember<SledAttribute, SledModifier> sled;

    EnumMap<ContestantAttribute, Integer> contestantAttributes;
    EnumMap<SledAttribute, Integer> sledAttributes;

    @Test
    void testDefaultStats() throws InvalidObjectAttributeType {

        this.contestant = new TeamMember<ContestantAttribute, ContestantModifer>("test", 
        ContestantAttribute.class,
         ContestantModifer.class);

        this.sled = new TeamMember<SledAttribute, SledModifier>("test", 
         SledAttribute.class,
          SledModifier.class);

        this.contestantAttributes = new EnumMap<ContestantAttribute, Integer>(ContestantAttribute.class);
        this.sledAttributes = new EnumMap<SledAttribute, Integer>(SledAttribute.class);

        this.contestantAttributes.put(ContestantAttribute.OFFENCE, 100);
        this.contestantAttributes.put(ContestantAttribute.DEFENCE, 100);
        this.contestantAttributes.put(ContestantAttribute.MAX_STANIMA, 100);
        this.contestantAttributes.put(ContestantAttribute.STANIMA, 100);


        this.sledAttributes.put(SledAttribute.ARMOUR, 100);
        this.sledAttributes.put(SledAttribute.SPEED, 100);

        assertEquals(this.contestantAttributes, this.contestant.getAttributes());
        assertEquals(this.sledAttributes, this.sled.getAttributes());
    }

    @Test
    void testCustomStats() throws InvalidObjectAttributeType {

        this.contestantAttributes = new EnumMap<ContestantAttribute, Integer>(ContestantAttribute.class);
        this.sledAttributes = new EnumMap<SledAttribute, Integer>(SledAttribute.class);

        this.contestant = new TeamMember<ContestantAttribute, ContestantModifer>("test", 
        
        new Object[][] {{ContestantAttribute.OFFENCE, 54},
                        {ContestantAttribute.DEFENCE, 34},
                        {ContestantAttribute.MAX_STANIMA, 37},
                        {ContestantAttribute.STANIMA, 37}},

        ContestantAttribute.class,
         ContestantModifer.class);

        this.sled = new TeamMember<SledAttribute, SledModifier>("test", 

        new Object[][] {{SledAttribute.ARMOUR, 54},
                        {SledAttribute.SPEED, 34}},
                        
        SledAttribute.class,
         SledModifier.class);

         this.contestantAttributes.put(ContestantAttribute.OFFENCE, 54);
         this.contestantAttributes.put(ContestantAttribute.DEFENCE, 34);
         this.contestantAttributes.put(ContestantAttribute.MAX_STANIMA, 37);
         this.contestantAttributes.put(ContestantAttribute.STANIMA, 37);

 
         this.sledAttributes.put(SledAttribute.ARMOUR, 54);
         this.sledAttributes.put(SledAttribute.SPEED, 34);

         assertEquals(this.contestantAttributes, this.contestant.getAttributes());
         assertEquals(this.sledAttributes, this.sled.getAttributes());        
    }
}
