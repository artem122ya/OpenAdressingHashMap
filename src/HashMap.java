public class HashMap {

    private int capacity;
    private int size;

    private int[] keyTable;
    private long[] valueTable;

    public HashMap(int capacity) {
        this.capacity = capacity;
        keyTable = new int[capacity];
        valueTable = new long[capacity];
    }

    public void put(int key, long value) {
        if (key == 0) throw new RuntimeException("Can't use zero as a key.");

        int probe = 0;
        do {
            int hash = (key + probe) % capacity;
            if (keyTable[hash] == 0 || keyTable[hash] == key) {
                if (keyTable[hash] == 0) size++;
                keyTable[hash] = key;
                valueTable[hash] = value;
                return;
            }
            probe++;
        } while (probe < capacity);

        throw new RuntimeException("Hash map overflow");
    }

    public long get(int key) {
        if (key == 0) throw new RuntimeException("Can't use zero as a key.");
        int probe = 0;
        do {
            int hash = (key + probe) % capacity;
            if (keyTable[hash] == key) {
                return valueTable[hash];
            }
            probe++;
        } while (probe < capacity);
        return 0;
    }

    public int size() {
        return size;
    }
}
