## PART 1 - Concept Analysis

| Feature | ArrayList | LinkedList |
|-------|---------|-----------|
| Internal Structure | Dynamic Array | Doubly Linked List |
| Access Time Complexity | O(1) | O(n) |
| Insertion Time Complexity | O(n) | O(1) at beginning/end |
| Deletion Time Complexity | O(n) | O(1) |
| Memory Usage | Less | More |

### Best Data Structure Choices

- Student record system – **ArrayList**
- Browser history – **LinkedList**
- Online shopping cart – **ArrayList**
- Undo/Redo feature – **LinkedList**

---

## PART 2 – Coding Tasks

### Task A – ArrayList Program

```java
import java.util.ArrayList;
import java.util.Collections;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(78);
        marks.add(85);
        marks.add(90);
        marks.add(67);
        marks.add(88);

        marks.add(2, 75);

        int min = Collections.min(marks);
        marks.remove(Integer.valueOf(min));

        System.out.println("Final Marks List: " + marks);
    }
}
```

### Task B – LinkedList as Queue

```java
import java.util.LinkedList;

public class TicketQueue {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Customer1");
        queue.add("Customer2");
        queue.add("Customer3");
        queue.add("Customer4");
        queue.add("Customer5");

        queue.remove();
        queue.remove();

        System.out.println("Remaining Queue: " + queue);
    }
}
```

---

## PART 3 – Singly Linked List Implementation

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    Node head;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
```

---
