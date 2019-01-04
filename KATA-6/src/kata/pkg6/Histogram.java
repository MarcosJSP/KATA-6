package kata.pkg6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram<T> {

    private Map<T,Integer> map;
    public Histogram(Iterator<T> iterator) {
        this(iterableOf(iterator));
    }

    public Histogram(Iterable<T> iterable) {
        map = new HashMap<>();
        for (T item : iterable) {
            add(item);
        }
    }
    
    private static <Z> Iterable<Z> iterableOf(Iterator<Z> iterator) {
        return new Iterable<Z>() {
            @Override
            public Iterator<Z> iterator() {
                return iterator;
            }
        };
    }

    private void add(T item) {
        map.put(item, map.containsKey(item) ? map.get(item)+1 : 1);
    }

    public Map<T,Integer> getMap() {
        return map;
    }
    
}
