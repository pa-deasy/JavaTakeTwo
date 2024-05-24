package linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LruCache {
    private Integer size;
    private LinkedList cache;
    private Map<Integer, Node> nodesMap;

    public LruCache(int size) {
        this.size = size;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPrevious(head);
        this.cache = new LinkedList(head, tail);
        this.nodesMap = new HashMap<Integer, Node>();
    }

    private void removeFromCache(Node node) {
        Node previous = node.getPrevious();
        Node next = node.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
    }

    private void addToCache(Node node) {
        Node tail = cache.getTail();
        Node previous = tail.getPrevious();
        previous.setNext(node);
        node.setPrevious(previous);
        node.setNext(tail);
        tail.setPrevious(node);
    }

    public Optional<Integer> get(Integer key) {
        Node node = nodesMap.get(key);
        if (node == null) {
            return Optional.empty();
        }

        removeFromCache(node);
        addToCache(node);
        return Optional.of(node.getValue());
    }

    public void put(Integer key, Integer value) {
        Node node = nodesMap.get(key);
        if (node != null) {
            removeFromCache(node);
        }

        Node newNode = new Node(key, value);
        addToCache(newNode);
        nodesMap.put(key, newNode);

        if (nodesMap.size() > size) {
            Node oldest = cache.getHead().getNext();
            nodesMap.remove(oldest.getKey());
            removeFromCache(oldest);
        }
    }
}
