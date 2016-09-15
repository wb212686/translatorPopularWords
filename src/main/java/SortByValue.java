import java.util.*;

/**
 * Created by Дмитрий on 15.09.2016.
 */
public class SortByValue {
    public static <String, Integer extends Comparable<? super Integer>> Map<String, Integer>
    sortByValue(Map<String, Integer> map )
    {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
