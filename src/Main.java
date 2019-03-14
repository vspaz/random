//import class_4.TicTacToe;

import class_5.*;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("John Doe",               "Dork",                 "joh.doe@aol.com",        "1123482552", 5_243.34, 41),
                new Employee("Adam Smith",             "Economist",            "adam@comcast.com",       "9033482552", 8_243.44, 141),
                new Employee("Homer Simpson",          "Garbage Commissioner", "homer@aol.com",          "9853482552", 1_243.31, 39),
                new Employee("Ned Flanders",           "school teacher",       "ned.flanders@gmail.com", "1120042552", 8_203.02, 50),
                new Employee("Apu Nahasapeemapetilon", "shop clerk",           "apu.nahas@aol.com",      "7773480502", 5_243.99, 41),
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
                System.out.println("=======================================");
            }
        }

        int[] nums = new int[] {
                5, 1, 5, 2, 2, 4, 1, 4, 5, 1, 5, 3, 2, 4, 4, 4, 5, 1, 3, 4, 2, 2, 1, 2, 4, 4, 4, 5, 4, 3, 5, 4, 4, 5, 5,
                1, 4, 1, 5, 3, 1, 4, 5, 3, 3, 4, 2, 2, 4, 4, 5, 5, 1, 1, 1, 4, 5, 5, 4, 4, 2, 4, 3, 1, 3, 3, 1, 1, 3, 1,
                3, 4, 4, 3, 2, 2, 1, 3, 4, 4, 2, 3, 4, 2, 4, 4, 1, 4, 4, 4, 2, 1, 2, 4, 1, 5, 2, 2, 5, 4, 2, 2, 3, 1, 5,
                5, 3, 5, 3, 1, 4, 5, 4, 2, 1, 3, 1, 2, 1, 4, 1, 3, 4, 2, 2, 5, 2, 3, 1, 1, 2, 3, 3, 4, 4, 2, 4, 1, 2, 2,
                2, 5, 1, 5, 1, 2, 2, 1, 3, 3, 4, 3, 5, 3, 5, 1, 2, 1, 3, 3, 2, 4, 1, 4, 3, 5, 1, 2, 1, 2, 3, 2, 1, 3, 2,
                2, 4, 3, 2, 1, 5, 1, 4, 5, 4, 4, 5, 5, 4, 2, 3, 5, 1, 3, 4, 3, 2, 4, 5, 2, 5, 2, 4, 1, 4, 5, 2, 3, 3, 4,
                4, 3, 5, 2, 2, 3, 5, 1, 2, 4, 3, 4, 4, 3, 2, 2, 1, 4, 5, 5, 1, 5, 2, 4, 5, 5, 4, 2, 2, 1, 5, 1, 3, 4, 2,
                4, 2, 2, 4, 3, 5, 2, 2, 4, 4, 4, 5, 5, 2, 5, 5, 2, 5, 1, 1, 5, 5, 4, 1, 2, 4, 1, 2, 2, 5, 4, 5, 1, 5, 4,
                4, 5, 5, 5, 3, 3, 4, 3, 3, 5, 3, 2, 2, 2, 2, 2, 1, 2, 5, 2, 3, 4, 3, 5, 5, 2, 4, 5, 3, 4, 3, 1, 3, 2, 1,
                1, 5, 4, 4, 2, 3, 1, 3, 4, 2, 4, 1, 3, 5, 1, 5, 3, 5, 2, 3, 4, 4, 1, 3, 1, 5, 5, 1, 2, 2, 1, 3, 1, 5, 1,
                2, 2, 1, 5, 1, 3, 3, 2, 1, 3, 2, 5, 1, 1, 2, 3, 5, 5, 4, 3, 1, 3, 3, 1, 5, 4, 2, 3, 4
        };

        HashMap<Integer, Integer> numToCount = Counter.countNumCount(nums);
        System.out.println("num count");
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            System.out.println(String.format("%d => %d", entry.getKey(), entry.getValue()));
        }
    }
}
