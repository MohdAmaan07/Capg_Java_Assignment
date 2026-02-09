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

class BubbleSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static StudentMarks[] sort(StudentMarks[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].marks >= students[j + 1].marks) {
                    if (students[j].marks == students[j + 1].marks && students[j].subject.compareTo(students[j + 1].subject) < 0) {
                        continue;
                    }
                    StudentMarks temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        return students;
    }

    public static StudentCollection[] sort(StudentCollection[] studentCollections) {
        for (int i = 0; i < studentCollections.length - 1; i++) {
            studentCollections[i].marks = BubbleSort.sort(studentCollections[i].marks);

            for (int j = 0; j < studentCollections.length - i - 1; j++) {
                int totalMarksJ = 0, totalMarksJ1 = 0;
                for (StudentMarks marks : studentCollections[j].marks) 
                    totalMarksJ += marks.marks;
                for (StudentMarks marks : studentCollections[j + 1].marks) 
                    totalMarksJ1 += marks.marks;

                if (totalMarksJ >= totalMarksJ1) {
                    if (totalMarksJ == totalMarksJ1 && studentCollections[j].name.compareTo(studentCollections[j + 1].name) < 0) {
                        continue;
                    }
                    StudentCollection temp = studentCollections[j];
                    studentCollections[j] = studentCollections[j + 1];
                    studentCollections[j + 1] = temp;
                }
            }
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
