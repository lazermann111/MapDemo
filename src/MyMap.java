import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_MAP_CAPACITY = 10;

    private Node<K, V>[] table;
    private int size;
    private int currentCapacity;

    public MyMap(int capacity) {
        table = new Node[capacity];
        currentCapacity = capacity;
        size = 0;
    }

    public MyMap() {
        this(DEFAULT_MAP_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        if (size < 0) {
            throw new IllegalStateException("Size cant be negative!");
        }
        return size == 0;
    }


    public boolean containsKey(Object o) {
        return false;
    }


    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public V get(@NotNull Object key) {
        int keyHash = key.hashCode();
        int bucketNum = keyHash % currentCapacity;
        Node<K, V> firstBucketElement = table[bucketNum];
        if(firstBucketElement == null){
            //no key was found in map
            return null;
        }else {
            Node<K, V> currentElem = firstBucketElement;
            if(currentElem.key.equals(key)){
                return currentElem.value;
            }
            Node<K, V> nextElem = firstBucketElement.next;
            while (nextElem != null){
                if(currentElem.key.equals(key)){
                    return currentElem.value;
                }
                currentElem = nextElem;
                nextElem = currentElem.next;
            }
        }
        return null;
    }


    /**
     *
     * @param key
     * @param value
     *
     * @throws IllegalArgumentException if passed key is null.
     * @return
     */
    public V put(@NotNull K key, @Nullable V value) {
        int keyHash = key.hashCode();
        int bucketNum = keyHash % currentCapacity;
        Node<K, V> firstBucketElement = table[bucketNum];
        if(firstBucketElement == null){
            table[bucketNum] = new Node<>(key, value, null);
        }else {
            Node<K, V> currentElem = firstBucketElement;
            if(currentElem.key.equals(key)){
                V toReturn = currentElem.value;
                currentElem.value = value;
                return toReturn;
            }
            Node<K, V> nextElem = firstBucketElement.next;
            while (nextElem != null){
                if(currentElem.key.equals(key)){
                    V toReturn = currentElem.value;
                    currentElem.value = value;
                    return toReturn;
                }
                currentElem = nextElem;
                nextElem = currentElem.next;
            }
            currentElem.next = new Node<>(key, value, null);
        }
        size++;
        return null;
    }

    @Override
    public String toString() {
        return "MyMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                ", currentCapacity=" + currentCapacity +
                '}';
    }

    @Override
    public V remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    static class MyMapEntry<K, V> implements Entry<K, V> {

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V v) {
            return null;
        }
    }

}
