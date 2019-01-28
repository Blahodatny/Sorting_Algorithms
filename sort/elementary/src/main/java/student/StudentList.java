package student;

public class StudentList {
    public static Node addFirst(Node head, Student value) {
        final var newNode = new Node(null, value, head);
        if (head != null)
            head.prev = newNode;
        return newNode;
    }

    public static void addAfter(Node node, Student value) {
        final var newNode = new Node(node, value, node.next);
        if (node.next != null)
            node.next.prev = newNode;
        node.next = newNode;
    }

    public static Node remove(Node head, Student value) {
        if (head == null) return null;
        var tail = head;
        while (tail.item != value) {
            tail = tail.next;
            if (tail == null)
                return null;
        }

        if (tail.prev != null)
            tail.prev.next = tail.next;

        if (tail.next != null)
            tail.next.prev = tail.prev;
        return head == tail ? head.next : head;
    }
}