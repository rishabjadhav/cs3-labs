public class MyHashTable<K, V> {
    private Object[] table;
    private int capacity = 11;

    public MyHashTable() {
        table = new Object[capacity];
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        table = new Object[capacity];
    }

    public V put(K key, V value) {
        Entry e = new Entry(key, value);

        int index = key.hashCode() % capacity;

        while (table[index] != null) {
            table[index] = ((Entry) table[index]).next;
        }
        table[index] = e;
        return null;
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;
        return (V) table[index];
    }

    public int size() {
        int s = 0;
        for (Object e : table) {
            if (e != null) {
                s++;
            }
        }
        return s;
    }

    public V remove(K key) {
        V returnable = (V) table[key.hashCode() % capacity];
        table[key.hashCode() % capacity] = null;
        return returnable;
    }


    private class Entry {
        private K key; //key
        private V value; //value
        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Entry getNext() {
            return next;
        }
        public void setNext(Entry e) {
            this.next = e;
        }
    }
}
