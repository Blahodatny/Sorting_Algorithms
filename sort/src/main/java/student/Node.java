package student;

class Node {
    Student item;
    Node next;
    Node prev;

    Node(Node prev, Student student, Node next) {
        this.item = student;
        this.next = next;
        this.prev = prev;
    }
}
