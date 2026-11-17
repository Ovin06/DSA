public class ArrayCircularQueue {
    private int[] data;
    private int front = 0, rear = -1, size = 0, capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() { return isEmpty() ? -1 : data[front]; }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.print(data[(front + i) % capacity] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(5);
        for (int i = 1; i <= 5; i++) q.enqueue(i * 10);
        q.display();
        q.enqueue(60);
        q.dequeue();
        q.dequeue();
        q.enqueue(60);
        q.enqueue(70);
        q.display();
    }
}