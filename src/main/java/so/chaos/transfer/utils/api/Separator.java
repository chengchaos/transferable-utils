package so.chaos.transfer.utils.api;

public interface Separator<X, K, V> {

    public  NamedData<K, V> detach(X input);
}
