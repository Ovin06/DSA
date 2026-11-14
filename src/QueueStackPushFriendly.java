import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        while (q1.size() > 1) q2.add(q1.remove());
        int top = q1.remove();
        Queue<Integer> temp = q1; q1 = q2; q2 = temp;
        return top;
    }

    public boolean isEmpty() { return q1.isEmpty(); }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(1); s.push(2); s.push(3);
        System.out.println(s.pop()); // 3
        System.out.println(s.pop()); // 2
    }
}