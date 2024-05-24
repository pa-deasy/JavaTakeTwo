package linkedlist;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LruCacheTest {
    @Test
    public void whenPutAndGetThenBehavesAsExpected() {
        LruCache lruCache = new LruCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(Integer.valueOf(1), lruCache.get(1).get());

        lruCache.put(3, 3);
        assertEquals(Optional.empty(), lruCache.get(2));

        lruCache.put(4, 4);
        assertEquals(Optional.empty(), lruCache.get(1));
        assertEquals(Integer.valueOf(3), lruCache.get(3).get());
        assertEquals(Integer.valueOf(4), lruCache.get(4).get());
    }
}