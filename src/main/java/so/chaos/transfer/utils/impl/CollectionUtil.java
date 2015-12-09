package so.chaos.transfer.utils.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import so.chaos.transfer.utils.api.NamedData;
import so.chaos.transfer.utils.api.Separator;

public class CollectionUtil {

    public static final <X, K, V> Map<K, V> toMap(
            Collection<X> collection, 
            Separator<X, K, V> separator) {
        
        Map<K, V> result = new HashMap<K, V>();
        
        for (X input : collection) {
            NamedData<K, V> namedData = separator.detach(input);
            
            if (namedData != null) {
                result.put(namedData.getKey(), namedData.getValue());
            }
        }
        
        return result;
    }
}
