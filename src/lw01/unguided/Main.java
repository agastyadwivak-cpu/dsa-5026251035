package lw01.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();

        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("Rentals.txt"))) {
            int totalRentals = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < totalRentals; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                String units = scanner.next();

                if (type.equalsIgnoreCase("LAPTOP")) {
                    rentals.add(new LaptopRental(id, days, Integer.parseInt(units)));
                } else if (type.equalsIgnoreCase("PROJECTOR")) {
                    rentals.add(new ProjectRental(id, days, Integer.parseInt(units)));
                }
                
            }
        }
        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}
