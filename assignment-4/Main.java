class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); 
        System.out.println("Stack size: " + stack.size()); 

        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Top element after pop: " + stack.peek()); 
        System.out.println("Stack size after pop: " + stack.size()); 
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    Node<T> top;
    private int size;

    Stack() {
        this.top = null;
        this.size = 0;
    }

    void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    T pop() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    T peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }
}