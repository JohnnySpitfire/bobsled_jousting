package org.beansinc.bobsled_jousting;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> Map<?, ?> write2DArrayToMap(Object[][] defaultStatsArr)  {
        //Uses a stream to map the 2D array of ContestantAttributes and their respective values to the contestantStats map
        //Using a map for easy and consistent access to the contestantStats data
        Map<?, ?> defaultStats = Stream.of(defaultStatsArr).collect
                                                            (Collectors.toMap(data -> (T) data[0],
                                                                             data -> (Integer) data[1]));
        return defaultStats;
    }
}
