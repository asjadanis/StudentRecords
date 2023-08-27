import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.util.*;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(110001,"Dave", new Date("11/18/1951")));
        students.add(new Student(110002,"Anna", new Date("12/07/1990")));
        students.add(new Student(110003, "Erica", new Date("01/31/1974")));
        students.add(new Student(110004, "Carlos", new Date("08/22/2009")));
        students.add(new Student(110005, "Bob", new Date("03/05/1990")));

        System.out.println("Students");
        printListOfStudents(students);

        List<Student> platinumStudents = getListOfPlatinumAlumniStudents(students);
        System.out.println("Platinum Students");
        printListOfStudents(platinumStudents);

        printHelloWorld(new int[]{5, 20, 30, 45,35, 42, 100});

        System.out.println("Second Biggest: " + findSecondBiggest(new int[]{-100, 200, 23, 14, 505}));
        System.out.println("Second Biggest: " + findSecondBiggest(new int[]{109, 19, 1111, 1230, -122, 1000}));
    }

    public static void printListOfStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();

        Date currentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int currentYear = cal.get(Calendar.YEAR);

        for (Student student : students) {
            cal.setTime(student.getDateOfAdmission());
            int admissionYear = cal.get(Calendar.YEAR);

            if (currentYear - admissionYear >= 30) {
                platinumAlumniStudents.add(student);
            }
        }

        return platinumAlumniStudents;
    }

    public static void printHelloWorld(int[] numbers) {
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        int firstBiggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstBiggest) {
                secondBiggest = firstBiggest;
                firstBiggest = num;
            } else if (num > secondBiggest ) {
                secondBiggest = num;
            }
        }

        return secondBiggest;
    }
}
