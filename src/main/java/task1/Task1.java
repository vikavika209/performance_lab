package task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        List<Integer> list = new LinkedList<>();
        int step = 1;

        do{
            list.add(step);

            if ((step + (m - 1)) <= n){
                step += (m - 1);

            }else if (((step + (m - 1))) % n == 0){
                step = n;
            }
            else {
                step = (step + (m - 1)) % n;
            }
        }while (step != 1);

        System.out.println(Arrays.toString(list.toArray()));

    }
}