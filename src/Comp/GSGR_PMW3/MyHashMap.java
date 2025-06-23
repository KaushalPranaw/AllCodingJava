package Comp.GSGR_PMW3;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor;

    // Entry class to hold key-value pairs
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Constructors
    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

        this.loadFactor = loadFactor;
        this.table = (Entry<K, V>[]) new Entry[initialCapacity];
        this.threshold = (int)(initialCapacity * loadFactor);
    }

    // Basic operations
    public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        // Check if key already exists
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        // Add new entry
        addEntry(hash, key, value, index);
        return null;
    }

    public V get(K key) {
        if (key == null)
            return getForNullKey();

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.key.equals(key))
                return e.value;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null)
            return removeForNullKey();

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry<K, V> prev = table[index];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.key.equals(key)) {
                if (prev == e)
                    table[index] = next;
                else
                    prev.next = next;
                size--;
                return e.value;
            }
            prev = e;
            e = next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++)
            table[i] = null;
        size = 0;
    }

    // Helper methods
    private V putForNullKey(V value) {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    private V getForNullKey() {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

    private V removeForNullKey() {
        Entry<K, V> prev = table[0];
        Entry<K, V> e = prev;

        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.key == null) {
                if (prev == e)
                    table[0] = next;
                else
                    prev.next = next;
                size--;
                return e.value;
            }
            prev = e;
            e = next;
        }
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    private void resize(int newCapacity) {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;

        @SuppressWarnings("unchecked")
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCapacity];
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);

        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> e = oldTable[i];
            if (e != null) {
                oldTable[i] = null;
                do {
                    Entry<K, V> next = e.next;
                    int index = indexFor(hash(e.key), newCapacity);
                    e.next = newTable[index];
                    newTable[index] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    private int hash(K key) {
        // This is a simple hash function. In production, you might want to use something more robust.
        return key == null ? 0 : key.hashCode();
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

}
