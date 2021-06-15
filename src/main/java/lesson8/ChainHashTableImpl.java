package lesson8;

import java.util.LinkedList;
import java.util.List;

public class ChainHashTableImpl<K, V> implements HashTable<K, V> {

    private final List<Item<K, V>>[] data;

    private int size;

    public ChainHashTableImpl(int initialCapacity) {
        this.data = new LinkedList[initialCapacity * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    private List<Item<K, V>> getChainByKey(K key) {
        int chainIdx = hashFunc(key);
        if (data[chainIdx] == null) {
            data[chainIdx] = new LinkedList<>();
        }
        return data[hashFunc(key)];
    }

    private int indexOf(K key) {
        List<Item<K, V>> chain = getChainByKey(key);
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean put(K key, V value) {
        Item<K, V> item = new Item<>(key, value);
        List<Item<K, V>> chain = getChainByKey(key);
        int chainIdx = indexOf(key);
        if (chainIdx == -1) {
            chain.add(item);
        } else {
            chain.set(chainIdx, item);
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int chainIdx = indexOf(key);
        if (chainIdx == -1) {
            return null;
        }
        return getChainByKey(key).get(chainIdx).getValue();
    }

    @Override
    public V remove(K key) {
        int chainIdx = indexOf(key);
        if (chainIdx == -1) {
            return null;
        }
        List<Item<K, V>> chain = getChainByKey(key);
        Item<K, V> item = chain.get(chainIdx);
        chain.remove(chainIdx);
        size--;
        return item.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
