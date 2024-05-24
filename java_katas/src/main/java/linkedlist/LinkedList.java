package linkedlist;

import lombok.Data;
import lombok.NonNull;

@Data
public class LinkedList {
    @NonNull private Node head;
    @NonNull private Node tail;
}
