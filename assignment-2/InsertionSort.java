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

class InsertionSort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static StudentMarks[] sort(StudentMarks[] students) {
        for (int i = 1; i < students.length; i++) {
            StudentMarks key = students[i];
            int j = i - 1;
            while (j >= 0 && (students[j].marks > key.marks
                    || (students[j].marks == key.marks && students[j].subject.compareTo(key.subject) > 0))) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
        return students;
    }

    public static StudentCollection[] sort(StudentCollection[] studentCollections) {

        for (StudentCollection sc : studentCollections) {
            sc.marks = InsertionSort.sort(sc.marks);
        }

        for (int i = 1; i < studentCollections.length; i++) {
            StudentCollection key = studentCollections[i];
            int totalMarksKey = 0;
            for (StudentMarks m : key.marks)
                totalMarksKey += m.marks;

            int j = i - 1;
            while (j >= 0) {
                int totalMarksJ = 0;
                for (StudentMarks m : studentCollections[j].marks)
                    totalMarksJ += m.marks;

                if (totalMarksJ > totalMarksKey ||
                    (totalMarksJ == totalMarksKey &&
                    studentCollections[j].name.compareTo(key.name) > 0)) {

                    studentCollections[j + 1] = studentCollections[j];
                    j--;
                } else {
                    break;
                }
            }
            studentCollections[j + 1] = key;
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
