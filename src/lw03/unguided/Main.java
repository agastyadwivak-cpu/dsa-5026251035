package lw03.unguided;
import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        Set<String> courses = new LinkedHashSet<>();
        List<String> check = new ArrayList<>();
        int rejected = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(!line.isEmpty()){
                String[] parts = line.split(" ");
                String type = parts[0];
                String course = parts[1];
                if(type.equals("REGISTER")){
                    int count = Integer.parseInt(parts[2]);
                    if(count <= 0){
                        rejected++;
                    } else {
                        enrollment.put(course, enrollment.getOrDefault(course, 0) + count);
                        courses.add(course);
                    }

                    
                } else if(type.equals("WITHDRAW")){
                    int count = Integer.parseInt(parts[2]);
                    if(count <= 0 || !enrollment.containsKey(course) || enrollment.get(course) < count){
                        rejected++;
                    } else {
                        enrollment.put(course, enrollment.getOrDefault(course, 0) - count);
                        courses.add(course);
                    }
                } else if(type.equals("CHECK")){
                    if(enrollment.containsKey(course)){
                        check.add(course + ": " + enrollment.get(course) + " students");
                    } else {
                        check.add(course + ": Not found");
                    }
                }
                

                
            }

        }
        sc.close();
        
        System.out.println("===== Enrollment Checks =====");
        for(String c : check){
            System.out.println(c);
        }

        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for(String c : courses){
            System.out.println(c + ": " + enrollment.getOrDefault(c, 0) + " students");
        }

        System.out.println();

        System.out.println("Rejected operations: " + rejected);
    }
}
