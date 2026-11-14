public class UnboundedArrayStack {
    private int[] data = new int[2];
    private int size = 0;

    public void push(int x) {
        if (size == data.length) resize(data.length * 2);   // grow
        data[size++] = x;
    }

    public int pop() {
        if (size == 0) throw new RuntimeException("Stack is empty");
        int val = data[--size];
        if (size > 0 && size == data.length / 4) resize(data.length / 2); // shrink
        return val;
    }

    private void resize(int newCap) {
        int[] newData = new int[newCap];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;
        System.out.println("Resized to " + newCap);
    }

    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        for (int i = 1; i <= 10; i++) s.push(i);
        for (int i = 1; i <= 9; i++) s.pop();
    }
}
