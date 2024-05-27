package linkedlist;

import lombok.Data;

@Data
public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
}
