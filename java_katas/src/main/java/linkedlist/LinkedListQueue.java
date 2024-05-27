package linkedlist;

import java.util.Optional;

public class LinkedListQueue {
    private LinkedList linkedList;

    public LinkedListQueue() {
        this.linkedList = new LinkedList();
    }

    public void enqueue(Integer value) {
        Node node = new Node(0, value);
        Node tail = linkedList.getTail();
        if (tail == null) {
            linkedList.setHead(node);
            linkedList.setTail(node);
        }
        else {
            tail.setNext(node);
            linkedList.setTail(node);
        }
    }

    public Optional<Integer> peek() {
        Node head = linkedList.getHead();

        return head == null ? Optional.empty() : Optional.of(head.getValue());
    }

    public Optional<Integer> dequeue() {
        Node head = linkedList.getHead();

        if (head == null) {
            return Optional.empty();
        }

        Node next = head.getNext();
        linkedList.setHead(next);
        if (next == null) {
            linkedList.setTail(null);
        }

        return Optional.of(head.getValue());
    }
}
