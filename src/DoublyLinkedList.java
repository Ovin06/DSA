public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertFirst(value); return; }
        if (index == size) { insertLast(value); return; }
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        Node node = new Node(value);
        node.prev = cur.prev;
        node.next = cur;
        cur.prev.next = node;
        cur.prev = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return; }
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteLast() {
        if (tail == null) { System.out.println("List is empty"); return; }
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public boolean deleteValue(int value) {
        Node cur = head;
        while (cur != null && cur.data != value) cur = cur.next;
        if (cur == null) return false;
        if (cur == head) { deleteFirst(); return true; }
        if (cur == tail) { deleteLast(); return true; }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
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

    public void displayForward() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " <-> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(10);
        list.insertLast(30);
        list.insertFirst(5);
        list.insertAt(2, 20);
        list.displayForward();
        list.displayBackward();
        list.deleteValue(20);
        list.deleteFirst();
        list.deleteLast();
        list.displayForward();
    }
}