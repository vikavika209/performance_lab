package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

//    расстояние от точки до центра окружности
//    равно квадратному корню из сумм квадратов разности соответствующих координат точки и центра круга

    public static void main(String[] args) {
        String circleDataFile = "src/main/java/task2/circle.txt";
        String dotDataFile = "src/main/java/task2/dot.txt";

        try{
            Scanner circleScanner = new Scanner(new File(circleDataFile));
            Scanner dotScanner = new Scanner(new File(dotDataFile));

            double x0 = circleScanner.nextDouble();
            double y0 = circleScanner.nextDouble();
            double r = circleScanner.nextDouble();

            while(dotScanner.hasNextLine()){
                double x = dotScanner.nextDouble();
                double y = dotScanner.nextDouble();

                double d = Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2));

                if (d == r){
                    System.out.println(0);
                }else if (d < r){
                    System.out.println(1);
                }else {
                    System.out.println(2);
                }
            }
            circleScanner.close();
            dotScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}