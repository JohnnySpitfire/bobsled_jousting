package org.beansinc.bobsled_jousting;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {

            Contestant jeff = new Contestant("jeff");
            Contestant tim = new Contestant("ryan", ContestantPositions.FORWARD);
            Contestant ryan = new Contestant("tim", ContestantPositions.BACK, new Object[][]{{ContestantAttributes.ALCOHOL_TOLERANCE, 100}});

            System.out.println(jeff.getName());
            System.out.println(ryan.getName());
            System.out.println(tim.getName());

            System.out.println(jeff.getEffects());
            System.out.println(ryan.getPosition());
            System.out.println(tim.getEffects());

            System.out.println(ryan.getStats());
            System.out.println(jeff.getStats());

            ryan.AddEffect(ContestantEffects.SLEEPY);

            System.out.println(ryan.getEffects());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
