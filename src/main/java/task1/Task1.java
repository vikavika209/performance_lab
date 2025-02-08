package task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        try {

            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            List<Integer> list = new LinkedList<>();
            int step = 1;

            do {
                list.add(step);

                if ((step + (m - 1)) <= n) {
                    step += (m - 1);

                } else if (((step + (m - 1))) % n == 0) {
                    step = n;
                } else {
                    step = (step + (m - 1)) % n;
                }
            } while (step != 1);

            System.out.println(Arrays.toString(list.toArray()));
        }catch (NumberFormatException e){
            System.out.println("Arguments must be integers.");
        }
    }
}