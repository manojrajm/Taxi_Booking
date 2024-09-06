package Taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Booking {
    public static void bookTaxi(int customerID, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> taxis) {
        List<Taxi> freeTaxis = getAvailableTaxis(taxis, pickupTime, pickupPoint);

        if (freeTaxis.isEmpty()) {
            System.out.println("No Taxi can be allotted. Booking is rejected.");
            return;
        }

        Taxi bookedTaxi = freeTaxis.get(0);
        int distance = Math.abs(dropPoint - pickupPoint) * 15; // Distance between points (15 KM apart)
        int fare = 100 + (distance - 5) * 10; // Calculate fare (first 5 KM at 100, then 10 per KM)
        int dropTime = pickupTime + distance / 15; // Calculate drop time

        bookedTaxi.updateDetails(dropPoint, dropTime, fare, customerID, pickupPoint, dropPoint, pickupTime);
        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + bookedTaxi.id + " is allotted.");
    }

    private static List<Taxi> getAvailableTaxis(List<Taxi> taxis, int pickupTime, char pickupPoint) {
        List<Taxi> freeTaxis = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            int travelTimeToPickup = Math.abs(taxi.currentSpot - pickupPoint) * 15;
            if (taxi.freeTime <= pickupTime && travelTimeToPickup <= (pickupTime - taxi.freeTime) * 15) {
                if (travelTimeToPickup < minDistance) {
                    freeTaxis.clear();
                    freeTaxis.add(taxi);
                    minDistance = travelTimeToPickup;
                } else if (travelTimeToPickup == minDistance) {
                    freeTaxis.add(taxi);
                }
            }
        }

        if (!freeTaxis.isEmpty()) {
            Collections.sort(freeTaxis, Comparator.comparingInt(t -> t.totalEarnings));
        }

        return freeTaxis;
    }

    public static void main(String[] args) {
        List<Taxi> taxis = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            taxis.add(new Taxi(i));
        }

        Scanner scanner = new Scanner(System.in);
        int customerId = 1;

        while (true) {
            System.out.println("0 -> Book Taxi");
            System.out.println("1 -> Print Taxi details");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Enter Pickup point (A-F): ");
                    char pickupPoint = scanner.next().charAt(0);
                    System.out.println("Enter Drop point (A-F): ");
                    char dropPoint = scanner.next().charAt(0);
                    System.out.println("Enter Pickup time (6-24): ");
                    int pickupTime = scanner.nextInt();

                    if (pickupPoint < 'A' || dropPoint > 'F' || pickupPoint > 'F' || dropPoint <'A') {
                        System.out.println("Valid pickup and drop points are A, B, C, D, E, F. Exiting.");
                        return;
                    }

                    bookTaxi(customerId++, pickupPoint, dropPoint, pickupTime, taxis);
                    break;

                case 1:
                    for (Taxi taxi : taxis) {
                        taxi.printTaxiDetails();
                        taxi.printTripHistory();
                    }
                    break;

                default:
                    return;
            }
        }
    }
}
