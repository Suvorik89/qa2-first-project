package homeWork4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListsHomeWork4 {
    List<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    static int pick;
    static double answer;

    @Test
    public void listActions() {
        for (int i = 0; i < 20; i++) {
            pick = random.nextInt(10);
            numbers.add(pick);
            System.out.println((i + 1) + ".number: " + pick);
        }

        for (int i = 0; i < numbers.size(); i++) {
            answer = numbers.get(i) / 2.0;
            if (answer == 4) {
                System.out.println("This is the number if dividing by 2 equal 4: " + (i + 1));
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0 && numbers.get(i) != 0) {
                System.out.println("This number is a multiple of 2: " + (i + 1));
            }
        }
    }
}
