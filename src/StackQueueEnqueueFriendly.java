import java.util.Stack;

public class StackQueueEnqueueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) {
        s1.push(x);
    }

    public int dequeue() {
        if (s1.isEmpty()) throw new RuntimeException("Queue is empty");
        while (!s1.isEmpty()) s2.push(s1.pop());
        int front = s2.pop();
        while (!s2.isEmpty()) s1.push(s2.pop());
        return front;
    }

    public boolean isEmpty() { return s1.isEmpty(); }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
    }
}