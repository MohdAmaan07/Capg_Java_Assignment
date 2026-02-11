## PART A - Conceptual Questions

1. Define Stack and explain LIFO principle.
```
Stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle for all its operations. 

This means that elements can only be added to or removed from a single end, typically referred to as the "top" of the stack.
```
2. What is Stack Overflow and Stack Underflow?
```
Stack Overflow — An error called when an item is pushed onto a stack, but the stack is full.

Stack Underflow — An error called when an item is called from a stack, but the stack is empty.
```
3. Write real-life examples of Stack.
```
- A stack of plates
- A pile of books
```
4. What is the time complexity of Push and Pop operations?
```
Push - O(1)
Pop - O(1)
```

---

## PART B – Dry Run Activity

```
Push(10)
- Top -> 10
Push(20) 
- Top -> 20
Push(30) 
- Top -> 30
Pop() 
- Top -> 20
Push(40) 
- Top -> 40
Peek() 
- Top -> 40

```

---

## PART C – Coding Task

```java
import java.util.Scanner;

class Stack {
    private int top;
    private int maxSize;
    private int[] stack;

    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            System.out.println(stack[top--] + " popped from stack.");
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        int size = sc.nextInt();

        Stack stack = new Stack(size);
        int choice, value;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

```

## Part D - Problem Solving Task

```java
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter parentheses expression: ");
        String expression = sc.nextLine();

        boolean isBalanced = true;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) 
            isBalanced = false;

        if (isBalanced) 
            System.out.println("The expression is Balanced.");
        else 
            System.out.println("The expression is Not Balanced.");

        sc.close();
    }
}

```
---
