public class Stack {
    private int[] items;
    private int top;
    
    public Stack(int size) {
        items = new int[size];
        top = -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == items.length - 1;
    }
    
    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        items[++top] = item;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items[top];
    }
    
    public int size() {
        return top + 1;
    }
}
