package student;

import java.util.Objects;

public class Node {
    Student item;
    Node next;
    Node prev;

    public Node(Node prev, Student student, Node next) {
        this.item = student;
        this.next = next;
        this.prev = prev;
    }

    public Student getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        var node = (Node) o;
        return getItem().equals(node.getItem()) &&
                getNext().equals(node.getNext()) &&
                prev.equals(node.prev);
    }

    public int hashCode() {
        return Objects.hash(getItem(), getNext(), prev);
    }
}