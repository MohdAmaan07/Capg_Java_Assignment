## PART 1 – Scenario Analysis

| Scenario | Best Choice | Reason |
|--------|-------------|-------|
| Real-time chat storage | LinkedList | Frequent insertions |
| Music playlist reorder | LinkedList | Easy rearrangement |
| Student search by index | ArrayList | Fast access |
| Browser navigation | LinkedList | Fast back/forward |
| Exam answers storage | ArrayList | Sequential storage |

---

## PART 2 – Coding Challenges

### Task A – ArrayList Advanced

```java
import java.util.ArrayList;
import java.util.Collections;

public class AdvancedArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.removeIf(n -> n % 2 == 0);

        int max = Collections.max(list);
        int min = Collections.min(list);

        list.sort(Collections.reverseOrder());

        System.out.println("Final List: " + list);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
```

### Task B – Hospital Queue

```java
import java.util.LinkedList;

public class HospitalQueue {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Patient1");
        queue.add("Patient2");
        queue.add("Patient3");
        queue.add("Patient4");
        queue.add("Patient5");

        queue.addFirst("Emergency Patient");

        queue.remove();
        queue.remove();

        System.out.println("Current Queue: " + queue);
    }
}
```

---

## PART 3 – Advanced Singly Linked List

```java
class AdvancedSLL {

    Node head;

    int countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    int findMiddle() {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
```

---
