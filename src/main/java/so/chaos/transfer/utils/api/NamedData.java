package so.chaos.transfer.utils.api;

import java.io.Serializable;

/**
 * 
 * @author chengchaos@gmail.com
 *
 */
public interface NamedData<K, V> extends Serializable {

    public K getKey();

    public String getKeyName();

    public V getValue();

}
