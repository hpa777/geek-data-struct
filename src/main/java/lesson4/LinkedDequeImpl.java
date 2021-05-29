package lesson4;

import lesson3.queue.Deque;

public class LinkedDequeImpl<E> implements Deque<E> {

    private final TwoSideLinkedListImpl<E> list = new TwoSideLinkedListImpl<>();


    @Override
    public boolean insertLeft(E value) {
        list.insertFirst(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return list.removeFirst();
    }

    @Override
    public E peekLeft() {
        return list.getFirst();
    }

    @Override
    public boolean insertRight(E value) {
        list.insertLast(value);
        return true;
    }

    @Override
    public E removeRight() {
        return list.removeLast();
    }

    @Override
    public E peekRight() {
        return list.getLast();
    }

    @Override
    public boolean insert(E value) {
        return insertRight(value);
    }

    @Override
    public E remove() {
        return removeRight();
    }

    @Override
    public E peekFront() {
        return peekRight();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        return "LinkedDequeImpl{" +
                "list=" + list +
                '}';
    }
}
