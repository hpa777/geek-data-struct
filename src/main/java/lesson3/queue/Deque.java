package lesson3.queue;

public interface Deque<E> extends Queue<E>{

    boolean insertLeft(E value);

    E removeLeft();

    E peekLeft();

    boolean insertRight(E value);

    E removeRight();

    E peekRight();

}
