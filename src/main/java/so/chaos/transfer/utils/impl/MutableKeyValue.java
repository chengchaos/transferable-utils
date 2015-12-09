package so.chaos.transfer.utils.impl;


import so.chaos.transfer.utils.api.NamedData;

/**
 * 
 * @author chengchaos@gmail.com
 *
 */
public class MutableKeyValue<K, V> implements NamedData<K, V> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private K key;
    private V value;

    public MutableKeyValue() {
        //
    }

    public MutableKeyValue(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    public MutableKeyValue<K, V> setKey(K key) {
        this.key = key;
        return this;
    }

    public MutableKeyValue<K, V> setValue(V value) {
        this.value = value;
        return this;
    }

//    public MutableKeyValue setId(Integer id) {
//        return this.setKey(id);
//    }
//
//    public MutableKeyValue setId(Long id) {
//        return this.setKey(id);
//    }
//
//    public MutableKeyValue setId(String id) {
//        return this.setKey(id);
//    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public String getKeyName() {
        return this.key.toString();
    }

    @Override
    public V getValue() {
        return this.value;
    }

    /**
     * 
     * @return
     */
    public NamedData<K, V> immutable() {
        return new KeyValue<K, V>(this.key, this.value);
    }

}
