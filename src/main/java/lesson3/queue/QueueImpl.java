package lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    protected static final int HEAD_DEFAULT = 0;
    protected static final int TAIL_DEFAULT = -1;

    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    // O(1)
    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;

        return true;
    }

    // O(1)
    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = HEAD_DEFAULT;
        }

        E value = data[head++];
        size--;

        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
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
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int start = head;
        if (head > tail) {
            start = HEAD_DEFAULT;
            for (int i = head; i < data.length ; i++) {
                sb.append(data[i]).append(", ");
            }
        }
        for (int i = start; i <= tail ; i++) {
            sb.append(data[i]);
            if (i < tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
