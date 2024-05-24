package linkedlist;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node {
    @NonNull private Integer key;
    @NonNull private Integer value;
    private Node previous;
    private Node next;
}
