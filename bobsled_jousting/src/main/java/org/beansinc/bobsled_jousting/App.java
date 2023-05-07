package org.beansinc.bobsled_jousting;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {

            Sled jeff = new Sled("jeff");
            Contestant ryan = new Contestant("ryan", ContestantPositions.FORWARD);
            Contestant tim = new Contestant("tim", ContestantPositions.BACK, new Object[][]{{ContestantAttributes.ALCOHOL_CONSUMED, 100}});

            System.out.println(jeff.getName());
            System.out.println(tim.getName());
            System.out.println(ryan.getName());

            tim.EditStat(ContestantAttributes.ALCOHOL_CONSUMED, 69);

            System.out.println(jeff.getName() + ": "+ jeff.getAttributes().get(SledAttributes.ARMOUR));

            System.out.println(jeff.getName() + ": "+ jeff.getAttributes());

            System.out.println(tim.getName() + ": "+ tim.getAttributes());
            System.out.println(ryan.getName() + ": "+ ryan.getAttributes());

            System.out.println(jeff.getName() + ": "+ jeff.getModifiers());
            System.out.println(tim.getName() + ": "+ tim.getModifiers());
            System.out.println(ryan.getName() + ": "+ ryan.getModifiers());

            tim.AddEffect(ContestantModifers.PARALYSED);
            ryan.AddEffect(ContestantModifers.SLEEPY);
            ryan.AddEffect(ContestantModifers.POISONED);

            int stanima = ryan.getAttributes(ContestantAttributes.STANIMA);

            System.out.println(stanima);

            System.out.println(tim.getName() + ": "+ tim.getModifiers());
            System.out.println(ryan.getName() + ": "+ ryan.getModifiers());


        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
