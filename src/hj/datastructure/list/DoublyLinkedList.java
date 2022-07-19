package hj.datastructure.list;

import ys.datastructure.list.indexException;

import java.util.*;
import java.util.List;

public class DoublyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E>{
        private Node<E> previous;
        private Node<E> next;
        private E value;

        Node(Node<E> previous, Node<E> next, E value){
            this.previous = previous;
            this.next = next;
            this.value = value;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        /* add : 마지막 인덱스에 더하기 */

        //size가 0이면 addFirst(e)
        if(head == null){
            addFirst(e);
            tail = head;
            size++;
            return true;
        }

        //size가 0이 아니면 마지막 노드에 추가
        addLast(e);
        size++;
        return true;
    }

    private void addLast(E e) {
        Node<E> newNode = new Node<>(tail, null, e);
        tail.next = newNode;
        tail = newNode;
    }

    private void addFirst(E e) {
        Node<E> newNode = new Node<>(null,head,e);
        head = newNode;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return getNode(index).value;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

        validateIndex(index);
        //index == 0 (첫노드 삽입)
        if(index == 0){
            addFirst(element);
            size++;
            return;
        }

        //index == size-1 (마지막 노드 삽입)
        if(index == size-1){
            addLast(element);
            size++;
            return;
        }

        // (중간 삽입)
        Node<E> tmpNode = getNode(index);
        Node<E> previousNode = tmpNode.previous;
        Node<E> newNode = new Node<>(previousNode,tmpNode,element);
        tmpNode.previous = newNode;
        previousNode.next = newNode;
        size++;

    }

    private Node<E> getNode(int index) {
        validateIndex(index);

        //인덱스가 리스트 크기의 절반보다 작으면 head부터 탐색
        if(index < size/2){
            Node<E> selectedNode = head;
            int count = 0;
            while(index > count){
                selectedNode = selectedNode.next;
                count++;
            }
            return selectedNode;
        }

        //인덱스가 리스트 크기의 절반보다 크면 tail부터 탐색
        Node<E> selectedNode = tail;
        int count = size-1;
        while(index < count){
            selectedNode = selectedNode.previous;
            count--;
        }
        return selectedNode;


    }

    private void validateIndex(int index) {
        //index validation
        //0 <= index < size
        try {
            if(!(0 <= index && index < size)) {
                throw new indexException();
            }
        } catch (indexException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}
