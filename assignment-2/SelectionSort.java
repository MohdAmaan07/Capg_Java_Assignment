class StudentMarks {
    String subject;
    int marks;
    StudentMarks(String subject, int marks) {
        this.subject = subject;
        this.marks = marks;
    }
}

class StudentCollection {
    String name;
    StudentMarks[] marks;
    StudentCollection(String name, StudentMarks[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

class SelectionSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static StudentMarks[] sort(StudentMarks[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].marks < students[minIndex].marks || (students[j].marks == students[minIndex].marks && students[j].subject.compareTo(students[minIndex].subject) < 0)) {
                    minIndex = j;
                }
            }
            StudentMarks temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }
        return students;
    }

    public static StudentCollection[] sort(StudentCollection[] studentCollections) {
        for (int i = 0; i < studentCollections.length - 1; i++) {
            studentCollections[i].marks = SelectionSort.sort(studentCollections[i].marks);

            int minIndex = i;
            for (int j = i + 1; j < studentCollections.length; j++) {
                int totalMarksJ = 0, totalMarksMin = 0;
                for (StudentMarks marks : studentCollections[j].marks)
                    totalMarksJ += marks.marks;
                for (StudentMarks marks : studentCollections[minIndex].marks)
                    totalMarksMin += marks.marks;

                if (totalMarksJ < totalMarksMin ||
                    (totalMarksJ == totalMarksMin && studentCollections[j].name.compareTo(studentCollections[minIndex].name) < 0)) {
                    minIndex = j;
                }
            }
            StudentCollection temp = studentCollections[minIndex];
            studentCollections[minIndex] = studentCollections[i];
            studentCollections[i] = temp;
        }
        return studentCollections;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] sortedArr = sort(arr);
        System.out.print("Sorted array: ");
        for (int num : sortedArr) 
            System.out.print(num + " ");

        System.out.println();

        StudentMarks[] students = {
            new StudentMarks("Alice", 80),
            new StudentMarks("Joe", 80),
            new StudentMarks("Bob", 80),
            new StudentMarks("Andy", 80),
            new StudentMarks("Bobby", 80),
            new StudentMarks("Charlie", 30)
        };
        System.out.println("\nSorted Students:");
        StudentMarks[] sortedStudents = sort(students);
        for (StudentMarks student : sortedStudents) 
            System.out.println(student.subject + " - " + student.marks);

        StudentCollection[] studentCollections = {
            new StudentCollection("Alice", new StudentMarks[]{new StudentMarks("Math", 90), new StudentMarks("Science", 70)}),
            new StudentCollection("Bob", new StudentMarks[]{new StudentMarks("Math", 70), new StudentMarks("Science", 80)}),
            new StudentCollection("Charlie", new StudentMarks[]{new StudentMarks("Math", 60), new StudentMarks("Science", 70)})
        };
        System.out.println("\nStudent Collections:");
        StudentCollection[] sortedStudentCollections = sort(studentCollections);
        for (StudentCollection collection : sortedStudentCollections) {
            System.out.println(collection.name + ":");
            for (StudentMarks marks : collection.marks) {
                System.out.println("  " + marks.subject + " - " + marks.marks);
            }
        }
    }   
}
