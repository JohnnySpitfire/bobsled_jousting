package org.beansinc.bobsled_jousting;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

import com.github.javafaker.Faker;

/**
 * General methods used throughout the application
 */
public class Utils {

    /** The Constant MIN_RANDOM_ATTRIBUTE. */
    private static final int MIN_RANDOM_ATTRIBUTE = 50;
    
    /** The Constant MAX_RANDOM_ATTRIBUTE. */
    private static final int MAX_RANDOM_ATTRIBUTE = 200;
 
    
    /**
     * Uses a stream to map the 2D array of ContestantAttributes and their respective values to the contestantStats map
     * Using a map for easy and consistent access to the contestantStats data
     *
     * @param <T> A generic type, must be an enumerator (should be Contestant or Sled Attributes)
     * @param defaultStatsArr A 2D array from an attributes class, containing {Attribute, Integer} pairs
     * @return Map<T, Integer> A generic map of Attributes mapped onto integers
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Map<?, ?> write2DArrayToMap(Object[][] defaultStatsArr)  {

        Map<T, Integer> defaultStats = Stream.of(defaultStatsArr).collect(Collectors.toMap(data -> (T) data[0], 
                                                                                    data -> (Integer) data[1]));
        return defaultStats;
    }

    
    /**
     *  Generates a random contestant
     *
     * @param rnd The persistent random object created in GameEnviroment
     * @param currentWeek The current week
     * @return randomContestant The newly generated Contestant
     * @throws InvalidObjectAttributeType
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
     *  Generates a random sled
     *
     * @param rnd The persistent random object created in GameEnviroment
     * @param currentWeek the current week
     * @return randomSled the newly generated sled
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
