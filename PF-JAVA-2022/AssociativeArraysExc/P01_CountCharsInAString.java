package AssociativeArraysExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01_CountCharsInAString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String textInput = scanner.nextLine().replaceAll("\\s+", "");

        LinkedHashMap <Character, Integer> charMap = new LinkedHashMap<>();

        for (char symbol: textInput.toCharArray()) {

            if (!charMap.containsKey(symbol)){
                charMap.put(symbol,1);
            } else {
                int currentCount = charMap.get(symbol);
                charMap.put(symbol, currentCount+1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
