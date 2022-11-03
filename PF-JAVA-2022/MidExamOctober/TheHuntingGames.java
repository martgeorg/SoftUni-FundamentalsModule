package MidExamOctober;

import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int daysOfAdventure = Integer.parseInt(scanner.nextLine());
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        double energyOfGroup = Double.parseDouble(scanner.nextLine());
        double waterPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());

        double totalWater = (waterPerPerson*daysOfAdventure*numberOfPlayers);
        double totalFood = (foodPerPerson*daysOfAdventure*numberOfPlayers);

        int dayForWater = 0;
        int dayForFood = 0;

        for (int i = 1; i <=daysOfAdventure ; i++) {
            double energyWasted = Double.parseDouble(scanner.nextLine());

            energyOfGroup -= energyWasted;

            if (energyOfGroup<=0){
                break;
            }

            dayForWater += 1;

            if (dayForWater>=2) {
                totalWater -= totalWater * 0.3;
                energyOfGroup += energyOfGroup*0.05;
                dayForWater = 0;
            }

            dayForFood += 1;

            if (dayForFood >= 3){
                totalFood -= (totalFood/numberOfPlayers);
                energyOfGroup += energyOfGroup*0.1;
                dayForFood = 0;
            }
        }

        if (energyOfGroup>=1){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energyOfGroup);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }






    }
}
