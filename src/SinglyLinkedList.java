public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) head = node;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        size++;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertFirst(value); return; }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) cur = cur.next;
        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return; }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) { System.out.println("List is empty"); return; }
        if (head.next == null) head = null;
        else {
            Node cur = head;
            while (cur.next.next != null) cur = cur.next;
            cur.next = null;
        }
        size--;
    }

    public boolean deleteValue(int value) {
        if (head == null) return false;
        if (head.data == value) { head = head.next; size--; return true; }
        Node cur = head;
        while (cur.next != null && cur.next.data != value) cur = cur.next;
        if (cur.next == null) return false;
        cur.next = cur.next.next;
        size--;
        return true;
    }

    public int search(int value) {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.data == value) return index;
            cur = cur.next;
            index++;
        }
        return -1;
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertFirst(5);
        list.insertAt(2, 15);
        list.display();
        System.out.println(list.search(15));
        list.deleteValue(10);
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}