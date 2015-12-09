package so.chaos.transfer.utils.impl;

import so.chaos.transfer.utils.api.NamedData;


/**
 * 
 * @author chengchaos@gmail.com
 *
 */
public class KeyValue<K, V> implements NamedData<K, V> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final K key;
    private final V value;
    
    public KeyValue(K key, V value) {
        super();
        if (key == null) {
            throw new IllegalStateException(" key must be not null ");
        }
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public String getKeyName() {
        return this.key.toString();
    }

    @Override
    public V getValue() {
        return value;
    }
    
    /**
     * 
     * @param key
     * @param value
     * @return
     */
    public static <K, V> NamedData<K, V> newInstance(K key, V value) {
        
        return new KeyValue<K, V>(key, value);
    }

}
