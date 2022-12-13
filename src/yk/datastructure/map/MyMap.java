package yk.datastructure.map;

public interface MyMap<K, E> { //실제 데이터가 아닌 임시 타입 이름 (명시적)
    // 인터페이스 접근제어자 불필요
    void put(K key, E value);

    E get(K key); // E 반환

    boolean remove(K key);

    boolean contains(K key);

    void clear();

    boolean isEmpty();
}
