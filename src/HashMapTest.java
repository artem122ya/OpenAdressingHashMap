import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    @Test
    public void putAndGetTest() {
        HashMap hashMap = new HashMap(10);
        hashMap.put(1000, 1);
        hashMap.put(500, 5);
        hashMap.put(1, 10);
        hashMap.put(1200, 10);
        assertEquals(1, hashMap.get(1000));
        assertEquals(5, hashMap.get(500));
        assertEquals(10, hashMap.get(1));
        assertEquals(10, hashMap.get(1200));
    }

    @Test
    public void sizeTest() {
        HashMap hashMap = new HashMap(10);
        hashMap.put(1, 10);
        hashMap.put(1, 11);
        hashMap.put(456, 10);
        assertEquals(2, hashMap.size());
    }

    @Test(expected = RuntimeException.class)
    public void putZeroKeyExceptionTest() {
        HashMap hashMap = new HashMap(10);
        hashMap.put(0, 10);
    }

    @Test(expected = RuntimeException.class)
    public void getZeroKeyExceptionTest() {
        HashMap hashMap = new HashMap(10);
        hashMap.put(1, 10);
        hashMap.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void hashMapOverflowExceptionTest() {
        HashMap hashMap = new HashMap(1);
        hashMap.put(1, 10);
        hashMap.put(2, 10);
    }

}
