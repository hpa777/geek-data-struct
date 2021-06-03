package lesson4;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private TwoSideNode<E> firstElement;

    private TwoSideNode<E> lastElement;


    @Override
    public void insertLast(E value) {
        TwoSideNode<E> newTwoSideNode = new TwoSideNode<>(value, null, null);
        if (isEmpty()) {
            firstElement = newTwoSideNode;
        } else {
            lastElement.next = newTwoSideNode;
            newTwoSideNode.prev = lastElement;
        }
        lastElement = newTwoSideNode;
        size++;
    }


    @Override
    public void insertFirst(E value) {
        TwoSideNode<E> newTwoSideNode = new TwoSideNode<>(value, null, null);
        if (isEmpty()) {
            lastElement = newTwoSideNode;
        } else {
            firstElement.prev = newTwoSideNode;
            newTwoSideNode.next = firstElement;
        }
        firstElement = newTwoSideNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        TwoSideNode<E> removedTwoSideNode = firstElement;
        firstElement = removedTwoSideNode.next;
        firstElement.prev = null;
        removedTwoSideNode.next = null;
        removedTwoSideNode.prev = null;

        size--;
        return removedTwoSideNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        TwoSideNode<E> removedTwoSideNode = lastElement;
        lastElement = removedTwoSideNode.prev;
        lastElement.next = null;
        removedTwoSideNode.next = null;
        removedTwoSideNode.prev = null;

        size--;
        return removedTwoSideNode.item;
    }

    @Override
    public E getLast() {
        return lastElement.item;
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public boolean remove(E value) {
        TwoSideNode<E> current = firstElement;
        TwoSideNode<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            removeLast();
            return true;
        } else {
            previous.next = current.next;
        }
        current.next = null;
        current.prev = null;
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        TwoSideNode<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}