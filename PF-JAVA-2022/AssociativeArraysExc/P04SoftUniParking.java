package AssociativeArraysExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nCommands = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String,String> parkingMap = new LinkedHashMap<>();

        for (int i = 1; i <=nCommands ; i++) {
            String arrayInput = scanner.nextLine();
            String [] inputArray = arrayInput.split("\\s+");
            String command = inputArray[0];


            if (command.equals("register")){
                String user = inputArray[1];
                String plate = inputArray[2];

                if(!parkingMap.containsKey(user)){
                    parkingMap.put(user,plate);
                    System.out.printf("%s registered %s successfully%n", user,plate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", parkingMap.get(user));
                }

            } else if (command.equals("unregister")){
                String user = inputArray[1];

                if (!parkingMap.containsKey(user)){
                    System.out.printf("ERROR: user %s not found%n", user);
                } else {
                    parkingMap.remove(user);
                    System.out.printf("%s unregistered successfully%n", user);
                }
            }
        }

        for (Map.Entry<String, String> entry : parkingMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
