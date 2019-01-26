package student;

public class StudentList {
    private Node first;
    private Node last;

    public void addFirst(Student student) {
        final var f = first;
        final var newNode = new Node(null, student, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
    }

    public void addLast(Student student) {
        final var l = last;
        final var newNode = new Node(l, student, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (var x = first; x != null; x = x.next)
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
        } else
            for (var x = first; x != null; x = x.next)
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
        return false;
    }

    private void unlink(Node x) {
        final var next = x.next;
        final var prev = x.prev;

        if (prev == null) first = next;
        else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) last = prev;
        else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
    }
}