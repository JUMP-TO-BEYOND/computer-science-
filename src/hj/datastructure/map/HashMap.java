package hj.datastructure.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_HASHTABLE_SIZE = 100;

    private static int tableSize = DEFAULT_HASHTABLE_SIZE;
    private int size = 0;
    private Node<K, V>[] hashTable = new Node[tableSize];

    public HashMap() {
        for(int i = 0; i < hashTable.length; i ++){
            hashTable[i] = new Node<> ();
        }
    }

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V previousValue = this.value;
            this.value = value;
            return previousValue;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

    }

    private static int getHashKey(Object key) {
        return Math.abs(Objects.hashCode(key)) % tableSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return isExistedBucket(getBucket(key));
    }

    private boolean hasNotKey(Object key) {
        return !containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> dummyBucket : hashTable) {
            if (isExistedValue(value, dummyBucket.getNext())) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistedValue(Object value, Node<K, V> bucket) {
        while (Objects.nonNull(bucket)) {
            if (bucket.getValue().equals(value)) {
                return true;
            }
            bucket = bucket.getNext();
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> bucketForKey = getBucket(key);
        if (isEmptyBucket(bucketForKey)) {
            return null;
        }
        return bucketForKey.getValue();
    }

    private Node<K, V> getBucket(Object key) {
        if (isEmpty()) {
            return null;
        }
        int index = getHashKey(key);
        Node<K, V> bucket = hashTable[index].getNext();

        return extractBucketForKey(key, bucket);
    }

    private Node<K, V> extractBucketForKey(Object key, Node<K, V> bucket) {
        if (isEmptyBucket(bucket)) {
            return null;
        }

        while (isExistedBucket(bucket)) {
            if (key.equals(bucket.getKey())) {
                return bucket;
            }
            bucket = bucket.getNext();
        }
        return null;
    }

    private boolean isEmptyBucket(Node<K, V> bucket) {
        return Objects.isNull(bucket);
    }

    private boolean isExistedBucket(Node<K, V> bucket) {
        return Objects.nonNull(bucket);
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> bucket = getBucket(key);
        if (isExistedBucket(bucket)) {
            return bucket.setValue(value);
        }

        int index = getHashKey(key);
        Node<K, V> currentBucket = hashTable[index];
        Node<K, V> newBucket = new Node<>(key, value);
        newBucket.setNext(currentBucket.getNext());
        currentBucket.setNext(newBucket);
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        if (isEmpty()) {
            return null;
        }
        if (hasNotKey(key)) {
            return null;
        }

        int index = getHashKey(key);
        Node<K, V> previousBucket = hashTable[index];
        Node<K, V> bucket = hashTable[index].getNext();
        while (isExistedBucket(bucket)) {
            if (key.equals(bucket.getKey())) {
                previousBucket.setNext(bucket.getNext());
                size--;
                return bucket.getValue();
            }
            previousBucket = bucket;
            bucket = bucket.getNext();
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        for(int i = 1; i < hashTable.length; i ++){
            hashTable[i] = new Node<K, V> ();
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        if (isEmpty()) {
            return null;
        }

        Set<K> keySet = new HashSet<>();
        for (Node<K, V> dummyBucket : hashTable) {
            Node<K, V> bucket = dummyBucket.getNext();
            while (isExistedBucket(bucket)) {
                keySet.add(bucket.getKey());
                bucket = bucket.getNext();
            }
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        if (isEmpty()) {
            return null;
        }

        Collection<V> values = new LinkedList<V>();
        for (Node<K, V> dummyBucket : hashTable) {
            Node<K, V> bucket = dummyBucket.getNext();
            while (isExistedBucket(bucket)) {
                values.add(bucket.getValue());
                bucket = bucket.getNext();
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return null;
        }

        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (Node<K, V> bucket : hashTable) {
            while (isExistedBucket(bucket)) {
                entrySet.add(bucket);
                bucket = bucket.getNext();
            }
        }

        return entrySet;
    }
}
