package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        try {
            String filePath = args[0];

            try {
                Scanner scanner = new Scanner(new File(filePath));

                List<Integer> nums = new ArrayList<>();

                int steps = 0;

                while (scanner.hasNext()) {
                    nums.add(scanner.nextInt());
                }

                scanner.close();

                nums.sort(Integer::compareTo);

                int mediana = nums.get(nums.size() / 2);

                for (int number : nums) {

                    int difference = number - mediana;

                    if (difference < 0) {
                        difference = -difference;
                    }

                    steps += difference;
                }

                System.out.println(steps);

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Args not found");
        }
    }
}
