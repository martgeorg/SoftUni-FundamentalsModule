package AssociativeArraysExcercise;

import java.util.*;

public class P05_Courses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        LinkedHashMap <String, ArrayList<String>> studentsMap = new LinkedHashMap<>();

        while (!inputLine.equals("end")){
            String[] courseArray = inputLine.split(" : ");

            String course = courseArray[0];
            String member = courseArray[1];

            if(!studentsMap.containsKey(course)){
                studentsMap.put(course,new ArrayList<>(Collections.singleton(member)));
            } else {
                studentsMap.get(course).add(member);
            }
            inputLine = scanner.nextLine();
        }
        

        for (Map.Entry<String, ArrayList<String>> entry : studentsMap.entrySet()) {
            int size = entry.getValue().size();
            System.out.printf("%s: %d%n", entry.getKey(), size);
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        }


    }
}
