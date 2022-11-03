package AssociativeArraysLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int number: numbersArr) {

            if (!countMap.containsKey(number)){
                countMap.put(number,0);
            }

            int currentValue = countMap.get(number);
            countMap.put(number, currentValue+1);

        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
