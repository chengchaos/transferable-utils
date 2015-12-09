package so.chaos.transfer.utils.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import so.chaos.transfer.utils.api.NamedData;
import so.chaos.transfer.utils.api.Separator;

public class CollectionUtilTest {

    @Test
    public void testToMap() {
        
        Collection<Integer> intList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            intList.add(Integer.valueOf(i));
        }
        
        Map<Integer, String> res = CollectionUtil.toMap(intList, new Separator<Integer, Integer, String>() {
            
            @Override
            public NamedData<Integer, String> detach(Integer input) {
                
                if (input == null) {
                    return null;
                }
                
                if (input.intValue() > 5) {
                    return KeyValue.newInstance(input, "大");
                } 
                
                return KeyValue.newInstance(input, "小");
            }
        });
        
        for (Map.Entry<Integer, String> entry : res.entrySet()) {
            System.err.println(entry.getKey() + ", "+ entry.getValue());
        }
        
    }
}
