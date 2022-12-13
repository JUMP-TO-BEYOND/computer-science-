package yk.datastructure.map;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HashTable<K, E> implements MyMap<K, E> {
    // hashing으로 순서가 없음 -> 그래서 keySet

    //TODO: linkedList 대신 head node 만들어 둠 -> for문으로 new Node (주소값 반환)
    // -> Arrarys.fill(rooms, new Node<>) -> 하나의 객체가 배열에 다 들어가서 for문으로 선언해야함.

    // Collision 대비 linkedList로 구현
    private final int size = 1000;
    private List<Node<K, E>>[] rooms = new LinkedList[size];

    private static class Node<K, E> { // inner class 객체 생성할 때마다 같이 생성됨, heap영역에 할당 -> 메모리 낭비
        K key;
        E value;

        private Node(K key, E value) {
            this.key = key;
            this.value = value;
        }

        private E getValue() { //setter, getter
            return value;
        }

        private void setValue(E value) {
            this.value = value;
        }
    }
    //Node inner Class End.


    // 메서드 start
    // TODO: 변하지 않고 공통의 메서드로 static -> length도 넘겨야함.
    private int hashing(K key) {
        int hashCode = Objects.hashCode(key);
        // null 이면 0 반환
        return Math.abs(hashCode) % rooms.length;
    }

    private Node searchKey(List<Node<K, E>> list, K key) {
        // TODO: null 반환이 2가지 경우로 이유를 정확히 알 수 없음 -> java optional 활용
        if (list == null) return null;

        for (Node<K, E> node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    // 추가
    public void put(K key, E value) {
        int index = hashing(key);
        // 변수 선언 시, 인터페이스로 선언 -> 캡슐화(의존성 줄임)

        if (Objects.isNull(rooms[index])) { // nonNull()
            rooms[index] = new LinkedList<Node<K, E>>();
        }

        Node node = searchKey(rooms[index], key);
        if (node == null) {
            rooms[index].add((new Node(key, value)));
        } else {
            node.setValue(value);
        }
    }

    // 반환
    public E get(K key) {    //1
        int index = hashing(key);
        List<Node<K, E>> list = rooms[index];

        Node<K, E> node = searchKey(list, key);
        return node == null ? null : node.getValue();
    }

    // 제거
    public boolean remove(K key) {
        int index = hashing(key);
        Node delNode = searchKey(rooms[index], key);
        return rooms[index].remove(delNode);
    }

    // 포함 여부
    public boolean contains(K key) {
        E value = get(key); // 수정
        return value == null ? false : true;
    }

    // 전체 삭제
    public void clear() {
        for (List<Node<K, E>> room : rooms) {
            if (room == null) continue;
            room.clear();
        }
    }

    // 데이터 비었는지 확인
    public boolean isEmpty() {
        for (List<Node<K, E>> room : rooms) {
            if (room == null) continue;
            if (room.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    //메서드 end.
}
