package lesson3.queue;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == HEAD_DEFAULT) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E peekLeft() {
        return super.peekFront();
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail == TAIL_DEFAULT) {
            tail = data.length - 1;
        }
        E value = data[tail--];
        size--;
        return value;
    }

    @Override
    public E peekRight() {
        return data[tail];
    }


}
