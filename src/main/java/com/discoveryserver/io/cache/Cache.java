package com.discoveryserver.io.cache;

public sealed interface Cache<K, V> permits MetadataCache {
    /**
     * This method use to put value in cache against key.
     *
     * @param key cache key.
     * @param value cache value.
     */
    void put(K key, V value);

    /**
     * This method is used to get value against key.
     *
     * @param key cache key.
     * @return value.
     */
    V get(K key);

    /**
     * This method is used to remove value against key.
     *
     * @param key cache key.
     */
    void remove(K key);

    /**
     * @return size of cache.
     */
    int size();

    /**
     * @return max size allowed for cache.
     */
    Long maxSize();

    /**
     * clear cache.
     */
    void clear();

    /**
     * This method will check if key exists in cache
     *
     * @param key key of cache
     */
    boolean contains(K key);

}
