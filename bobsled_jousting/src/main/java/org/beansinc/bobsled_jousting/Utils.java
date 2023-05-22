package org.beansinc.bobsled_jousting;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

import com.github.javafaker.Faker;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
public class Utils {

    /** The Constant MIN_RANDOM_ATTRIBUTE. */
    private static final int MIN_RANDOM_ATTRIBUTE = 50;
    
    /** The Constant MAX_RANDOM_ATTRIBUTE. */
    private static final int MAX_RANDOM_ATTRIBUTE = 200;
 
    
    /**
     *  
     *
     * @param <T> the generic type
     * @param defaultStatsArr the default stats arr
     * @return Map<?, ?>
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Map<?, ?> write2DArrayToMap(Object[][] defaultStatsArr)  {
        //Uses a stream to map the 2D array of ContestantAttributes and their respective values to the contestantStats map
        //Using a map for easy and consistent access to the contestantStats data
        Map<?, ?> defaultStats = Stream.of(defaultStatsArr).collect(Collectors.toMap(data -> (T) data[0], 
                                                                                    data -> (Integer) data[1]));
        return defaultStats;
    }

    
    /**
     *  
     *
     * @param rnd the rnd
     * @param currentWeek the current week
     * @return Contestant
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public static Contestant generateRandomContestant(Random rnd, int currentWeek) throws InvalidObjectAttributeType {

        Faker faker = new Faker();
        String randomName = faker.name().firstName();
  
        Object[][] randomAttributes = ContestantAttribute.getDefaultAttributes();
    
        for(Object[] attr : randomAttributes){

           int attributeVal = (int) (MIN_RANDOM_ATTRIBUTE 
                            + rnd.nextInt(MAX_RANDOM_ATTRIBUTE - MIN_RANDOM_ATTRIBUTE)
                            * (1 + ((float) currentWeek)/10f));

           attr[1] = attributeVal;
  
        }
  
        Contestant randomContestant = new Contestant(randomName, randomAttributes);
        
        int maxStanima = randomContestant.getAttribute(ContestantAttribute.MAX_STANIMA);
        randomContestant.editAttribute(ContestantAttribute.STANIMA, maxStanima);
        
        return randomContestant;
    }
    
    /**
     *  
     *
     * @param rnd the rnd
     * @param currentWeek the current week
     * @return Contestant
     * @throws InvalidObjectAttributeType the invalid object attribute type
     */
    public static Sled generateRandomSled(Random rnd, int currentWeek) throws InvalidObjectAttributeType {
          
        Object[][] randomAttributes = SledAttribute.getDefaultAttributes();
    
        for(Object[] attr : randomAttributes){

            int attributeVal = (int) (MIN_RANDOM_ATTRIBUTE 
                            + rnd.nextInt(MAX_RANDOM_ATTRIBUTE - MIN_RANDOM_ATTRIBUTE)
                            * (1 + ((float) currentWeek)/10f));     

            attr[1] = attributeVal;
  
        }
  
        Sled randomSled = new Sled(randomAttributes);
        
        return randomSled;
    }
}
