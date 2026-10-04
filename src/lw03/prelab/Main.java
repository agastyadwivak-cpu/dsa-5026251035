package lw03.prelab;

import java.util.*;
public class Main {
    public static void main(String[]args){

        //problem 1
        List<String> playlist = new ArrayList<>();
        Scanner pl = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while(pl.hasNextLine()){
            String line = pl.nextLine();

            if(!line.isEmpty()){
                String[] parts = line.split(" ", 2);
                String type = parts[0];

                if (type.equals("ADD")) {
                    playlist.add(parts[1]);
                } else if (type.equals ("INSERT")) {
                    String[] insertParts = parts[1].split(" ", 2);
                    int index = Integer.parseInt(insertParts[0]);
                    String song = insertParts[1];
                    playlist.add(index, song);
                } else if (type.equals("REMOVE")) {
                    playlist.remove(parts[1]);
                }
            }
        }
        pl.close();


        //problem 2
        Set<String> participants = new LinkedHashSet<>();
        int count = 0;
        Scanner pp = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while(pp.hasNextLine()){
            String name = pp.nextLine();
            if(!name.isEmpty()){
                boolean added = participants.add(name);
                if(!added){
                    count++;
                }
            }
        }
        pp.close();

        //problem 3
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedsales = 0;
        Scanner inven = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while(inven.hasNextLine()){
            String line = inven.nextLine();

            if(!line.isEmpty()){
                String[] parts = line.split(" ");
                String type = parts[0];
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                
                if (type.equals("ADD")) {
                    inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
                } else if (type.equals("SELL")) {
                    if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                        inventory.put(product, inventory.get(product) - quantity);
                    } else {
                        failedsales++;

                    }
                }
            }
        }
        inven.close();
        
        //output problem 1
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();
        
        //output problem 2
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int idx = 1;
        for (String p : participants) {
            System.out.println(idx + ". " + p);
            idx++;
        }
        System.out.println("Duplicate registrations: " + count);
        System.out.println();

        //output problem 3
        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedsales);
    }
}
