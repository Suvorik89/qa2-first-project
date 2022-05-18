package homeWork4;

import homeWork1.Transport;
import lesson2.Student;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ListsHomeWork4 {
    List<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    static int pick;
    static double answer;

    @Test
    public void listActions() {
        System.out.println("1. exercise");
        for (int i = 0; i < 20; i++) {
            pick = random.nextInt(10);
            numbers.add(pick);
            System.out.println((i + 1) + ".number: " + pick);
        }

        for (int i = 0; i < numbers.size(); i++) {
            answer = numbers.get(i) / 2.0;
            if (answer == 4) {
                System.out.println("This is the number if dividing by 2 equal 4: " + (i + 1) + ". number");
            }
        }
        System.out.println("2. exercise");
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0 && numbers.get(i) != 0) {
                System.out.println("This number is a multiple of 2: " + (i + 1) + ". number");
            }
        }

        /*List<Student> students = new ArrayList<Student>();
        students.add(0, new Student("Jekaterina", "Suvorova", 32, "180989-10032", "QA2"));
        students.add(1, new Student("Dmitrijs", "Dankovs", 45, "300177-11522", "QA1"));
        students.add(2, new Student("Tatjana", "Kosareva", 51, "110171-12345", "QA2"));
        students.add(3, new Student("Artjoms", "Suvorovs", 31, "161290-10001", "QA2"));
        students.add(4, new Student("Nikolajs", "Mihalciks", 39, "200983-12501", "QA1"));

        students.forEach((v) -> System.out.println(v.getFirstName()));*/

        Map<String, Student> students = new HashMap<String, Student>();
        students.put("1", new Student("Jekaterina", "Suvorova", 32, "180989-10032", "QA2"));
        students.put("2", new Student("Dmitrijs", "Dankovs", 45, "300177-11522", "QA1"));
        students.put("3", new Student("Tatjana", "Kosareva", 51, "110171-12345", "QA2"));
        students.put("4", new Student("Artjoms", "Suvorovs", 31, "161290-10001", "QA2"));
        students.put("5", new Student("Nikolajs", "Mihalciks", 39, "200983-12501", "QA1"));

        System.out.println("3, 4. exercises");
        students.forEach((k, v) -> {
            if (v.getCourse().equals("QA2")) {
                System.out.println(k + " key: " + v.getFirstName() + " " + v.getCourse());
            }
        });
    }
}
