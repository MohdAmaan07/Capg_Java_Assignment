## Part A: Application-Based Questions
1. Explain how stack is used in function calls (Call Stack).
```
Each function call is pushed onto the stack with its local variables and return address; it is popped when the function finishes execution.
```
2. How is stack used in Undo/Redo operations?
```
Actions are pushed onto an undo stack; undo pops the last action, and redo uses another stack to reapply undone actions.
```
3. Why is stack useful in expression evaluation?
```
Stack helps store operands/operators temporarily, enabling correct order of operations (especially in postfix/prefix evaluation).
```
4. Differentiate between Infix, Prefix, and Postfix expressions.
```
Infix places operator between operands (A+B), Prefix before operands (+AB), and Postfix after operands (AB+).
```

## Part B: Coding Activity 1 – Balanced Parentheses

```java
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        if (isBalanced) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        sc.close();
    }
}

```

## Part C: Coding Activity 2 – Infix to Postfix Conversion


```java
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop()
            }

            else {
                while (!stack.isEmpty() && 
                       precedence(stack.peek()) >= precedence(ch)) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        System.out.println(postfix);
        sc.close();
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }
}


```


## Part D: Stack Challenge Problem

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

```

## Part E: Analytical Task

| Operation                  | Time Complexity |
| -------------------------- | --------------- |
| Push                       | O(1)            |
| Pop                        | O(1)            |
| Peek                       | O(1)            |
| Balanced Parentheses Check | O(n)            |
