package lesson4;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E removeLast();

    E getLast();

    class TwoSideNode<E> {
        E item;

        TwoSideNode<E> next;

        TwoSideNode<E> prev;

        public TwoSideNode(E item, TwoSideNode<E> prev, TwoSideNode<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
