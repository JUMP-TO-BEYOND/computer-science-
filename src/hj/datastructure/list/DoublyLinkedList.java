package hj.datastructure.list;

import java.util.Comparator;

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
    public E search(E obj, Comparator<? super E> c) {
        return null;
    }

    @Override
    public void addFirst(E obj) {

    }

    @Override
    public void addLast(E obj) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void removeCurrentNode() {

    }

    @Override
    public void clear() {

    }
}
