package AssociativeArraysExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_MinerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String resources = scanner.nextLine();

        LinkedHashMap <String,Integer> resourcesMap = new LinkedHashMap<>();



        while (!resources.equals("stop")){

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesMap.containsKey(resources)){
                resourcesMap.put(resources, quantity);
            } else {
                int currentQuantity = resourcesMap.get(resources);

                resourcesMap.put(resources, currentQuantity+quantity);
            }
            resources = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourcesMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
