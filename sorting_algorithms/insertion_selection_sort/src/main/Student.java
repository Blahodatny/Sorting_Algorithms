package main;

import java.util.stream.IntStream;

public class Student {
    private String name;
    private String surname;
    private String form;
    private Student prev;
    private Student next;

    public static boolean isValidSurName(String string) {
        if (!Character.isUpperCase(string.charAt(0)))
            return false;
        return IntStream.range(1, string.length()).allMatch(i -> Character.isAlphabetic(string.charAt(i)));
    }

    public static boolean isValidForm(String form) {
        return form.compareTo("budget") == 0 || form.compareTo("contract") == 0;
    }

    public void print() {
        System.out.println(String.format("%-10s|   %-15s|  %-10s|", name, surname, form));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Student getPrev() {
        return prev;
    }

    public Student getNext() {
        return next;
    }

    private static void addAfter(Student student, Student node) {
        if (node == null)
            return;
        node.next = student.next;
        node.prev = student;
        if (student.next != null)
            student.next.prev = node;
        student.next = node;
    }

    public static Student addFirst(Student head, Student node) {
        if (head != null)
            head.prev = node;
        if (node != null)
            node.next = head;
        return node;
    }

    public static Student addNode(Student head, Student node) {
        if (head == null)
            head = addFirst(null, node);
        else {
            var tail = head;
            if (tail.next != null)
                while (tail.next != null)
                    tail = tail.next;
            addAfter(tail, node);
        }
        return head;
    }

    public static Student deleteNode(Student dlHead, Student cur) {
        var temp = dlHead;
        while (temp != cur)
            temp = temp.next;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            return null;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        cur.next = null;
        cur.prev = null;
        return dlHead;
    }
}