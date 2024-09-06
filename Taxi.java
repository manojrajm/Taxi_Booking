package Taxi;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    public int id;
    public char currentSpot;
    public int freeTime;
    public int totalEarnings;
    public List<Trip> tripDetails;

    public Taxi(int id) {
        this.id = id;
        this.currentSpot = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.tripDetails = new ArrayList<>();
    }

    public void updateDetails(char newSpot, int newFreeTime, int fare, int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        this.currentSpot = newSpot;
        this.freeTime = newFreeTime;
        this.totalEarnings += fare;

        Trip trip = new Trip(customerId, pickupPoint, dropPoint, pickupTime, newFreeTime, fare);
        this.tripDetails.add(trip);
    }

    public void printTaxiDetails() {
        System.out.printf("Taxi %d | Current Spot: %c | Free Time: %d | Total Earnings: %d%n",
                this.id, this.currentSpot, this.freeTime, this.totalEarnings);
    }

    public void printTripHistory() {
        System.out.println("Taxi " + this.id + " Trip History:");
        System.out.printf("%-12s %-8s %-8s %-12s %-10s %-10s%n",
                "CustomerID", "Pickup", "Drop", "PickupTime", "DropTime", "Earnings");

        for (Trip trip : tripDetails) {
            System.out.printf("%-12d %-8c %-8c %-12d %-10d %-10d%n",
                    trip.customerId, trip.pickupPoint, trip.dropPoint, trip.pickupTime, trip.dropTime, trip.earnings);
        }
        System.out.println();
    }
}

class Trip {
    int customerId;
    char pickupPoint;
    char dropPoint;
    int pickupTime;
    int dropTime;
    int earnings;

    public Trip(int customerId, char pickupPoint, char dropPoint, int pickupTime, int dropTime, int earnings) {
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.earnings = earnings;
    }
}
