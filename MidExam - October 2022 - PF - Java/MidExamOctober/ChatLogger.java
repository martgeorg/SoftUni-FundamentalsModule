package MidExamOctober;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatLogger {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> chatList = new ArrayList<>();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("end")){

            String [] commandArray = commandLine.split(" ");
            String command = commandArray[0];

            switch (command){

                case "Chat":
                    String messageToAdd = commandArray [1];
                    chatList.add(chatList.size(),messageToAdd);

                    break;

                case "Delete":
                    String messageToDelete = commandArray[1];
                    if (chatList.contains(messageToDelete)){
                        chatList.remove(messageToDelete);
                    }
                    break;

                case "Edit":
                    String messageToEdit = commandArray[1];
                    String editedElement = commandArray[2];
                    int indexOfElement = 0;

                    for (int i = 0; i <= chatList.size()-1; i++) {
                        String currentElement = chatList.get(i);

                        if (currentElement.equals(messageToEdit)){
                            indexOfElement += i;
                        }

                    }
                    if (chatList.contains(messageToEdit)){
                        chatList.set(indexOfElement,editedElement);
                    }
                    break;
                case "Pin":
                    String messageToPin = commandArray[1];
                    int initialIndex = 0;

                    for (int i = 0; i <= chatList.size()-1 ; i++) {
                        String currentElement = chatList.get(i);

                        if (currentElement.equals(messageToPin)){
                            initialIndex += i;
                        }
                    }

                    if (chatList.contains(messageToPin)){
                        chatList.add(chatList.size(), messageToPin);
                        chatList.remove(initialIndex);
                    }
                    break;

                case "Spam":
                    List <String> subSpamList = new ArrayList<>();

                    for (int i = 1; i <= commandArray.length-1; i++) {
                        String textToAdd = commandArray[i];
                        subSpamList.add(textToAdd);
                    }

                    chatList.addAll(subSpamList);

                    break;
            }

            commandLine = scanner.nextLine();
        }

        for (String chat: chatList) {
            System.out.println(chat);
        }
    }
}
