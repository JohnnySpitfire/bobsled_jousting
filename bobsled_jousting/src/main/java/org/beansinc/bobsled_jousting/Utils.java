package org.beansinc.bobsled_jousting;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;

public class Utils {

    private static final int MIN_RANDOM_ATTRIBUTE = 50;
    private static final int MAX_RANDOM_ATTRIBUTE= 200;
 
    private static final int CONTESTANT_BASE_VALUE = 50;
    private static final int CONTESTANT_ATTRIBUTE_VALUE_FACTOR = 8;
    
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Map<?, ?> write2DArrayToMap(Object[][] defaultStatsArr)  {
        //Uses a stream to map the 2D array of ContestantAttributes and their respective values to the contestantStats map
        //Using a map for easy and consistent access to the contestantStats data
        Map<?, ?> defaultStats = Stream.of(defaultStatsArr).collect(Collectors.toMap(data -> (T) data[0], 
                                                                                    data -> (Integer) data[1]));
        return defaultStats;
    }

    public static Contestant generateRandomContestant(Random rnd) throws InvalidObjectAttributeType {

        String[] contestantNames = {"Steve", "Elliot", "Jim", "Finn", "Lisa", "Emily", "Flynn", "Zoe", "Jamie", "Ryan", "Hamish", "Will", "Ben"};
        
        String randomName = contestantNames[rnd.nextInt(contestantNames.length - 1)];
        ContestantPosition randomPosition = ContestantPosition.getRandomPosition(rnd);
  
        Object[][] randomAttributes = ContestantAttribute.getDefaultAttributes();
  
        int value = CONTESTANT_BASE_VALUE;
  
        for(Object[] attr : randomAttributes){
           int attributeVal = MIN_RANDOM_ATTRIBUTE + rnd.nextInt(MAX_RANDOM_ATTRIBUTE - MIN_RANDOM_ATTRIBUTE);
           
           value += CONTESTANT_BASE_VALUE + attributeVal / CONTESTANT_ATTRIBUTE_VALUE_FACTOR;
           attr[1] = attributeVal;
  
        }
  
        Contestant randomContestant = new Contestant(randomName, randomPosition, randomAttributes, value);
        
        return randomContestant;
     }
}
