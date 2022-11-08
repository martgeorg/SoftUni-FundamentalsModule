package AssociativeArraysExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String order = scanner.nextLine();

        LinkedHashMap <String, Double> mapOrders = new LinkedHashMap<>();
        LinkedHashMap <String, Integer> mapQuantity = new LinkedHashMap<>();


        while (!order.equals("buy")){
            String product = order.split(" ")[0];
            double price = Double.parseDouble(order.split(" ")[1]);
            int quantity = Integer.parseInt(order.split(" ")[2]);

            mapOrders.put(product,price);

            if(!mapQuantity.containsKey(product)) {
                mapQuantity.put(product, quantity);
            } else {
                mapQuantity.put(product, mapQuantity.get(product) + quantity);
            }


            order = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : mapOrders.entrySet()) {
            double finalPrice = entry.getValue() * mapQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), finalPrice);
        }

    }
}
