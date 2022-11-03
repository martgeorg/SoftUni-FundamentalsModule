package MidExamOctober;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        int blacklistedCount = 0;
        int lostNamesCount = 0;

        while (!commandLine.equals("Report")){
            String [] commandArray = commandLine.split(" ");
            String command = commandArray[0];

            switch (command){

                case "Blacklist":
                    String nameToBlacklist = commandArray[1];
                    int indexOfElement = 0;

                    for (int i = 0; i <= stringList.size()-1; i++) {
                        String currentElement = stringList.get(i);

                        if (currentElement.equals(nameToBlacklist)){
                            indexOfElement += i;
                        }

                    }
                    if (stringList.contains(nameToBlacklist)){
                        stringList.set(indexOfElement,"Blacklisted");
                        System.out.printf("%s was blacklisted.%n", nameToBlacklist);
                        blacklistedCount++;
                    } else {
                        System.out.printf("%s was not found.%n", nameToBlacklist);
                    }

                    break;
                case "Error":
                    int indexToCheck = Integer.parseInt(commandArray[1]);
                    if (indexToCheck >=0 && indexToCheck <= stringList.size()-1){
                        String currentName = stringList.get(indexToCheck);

                        if (!currentName.contains("Blacklisted") && !currentName.contains("Lost")){
                            stringList.set(indexToCheck, "Lost");
                            lostNamesCount++;
                            System.out.printf("%s was lost due to an error.%n", currentName);
                        }
                    }
                    break;
                case "Change":
                    int indexToChange = Integer.parseInt(commandArray[1]);
                    String nameToChange = commandArray[2];
                    if (indexToChange >=0 && indexToChange <= stringList.size()-1){
                        String oldName = stringList.get(indexToChange);

                        stringList.set(indexToChange, nameToChange);
                        System.out.printf("%s changed his username to %s.%n", oldName, nameToChange);
                    }
                    break;

            }
            commandLine = scanner.nextLine();
        }

        System.out.printf("Blacklisted names: %d%n", blacklistedCount);
        System.out.printf("Lost names: %d%n", lostNamesCount);

        for (String names: stringList) {
            System.out.print(names + " ");
        }

    }
}
