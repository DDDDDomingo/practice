package normal.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: LRU缓存
 * @author: yifan
 * @date: 2019/8/23 15:08
 */
public class LRUCache<V> {
    /**
     * 容量
     */
    private int capacity = 1024;
    /**
     * 节点数
     */
    private Map<String, ListNode<String, V>> table = new ConcurrentHashMap<String, ListNode<String, V>>();

    class ListNode<K, V> {
        private K key;
        private V value;
        private ListNode<String, V> prev;
        private ListNode<String, V> next;

        private V get(K key) {
//            if(key.)
            return this.value;
        }
    }
}
