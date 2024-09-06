# Taxi Booking System

A simple command-line-based Taxi Booking System that allocates taxis based on availability, location, and earnings. The system aims to provide an optimal taxi allocation strategy for customers while ensuring fairness in earnings distribution among drivers.

## Features

- Book a taxi by specifying pickup and drop locations.
- Automatically finds the closest available taxi to the pickup point.
- Prioritizes taxis with the lowest total earnings to ensure fair distribution of trips.
- Displays each taxi's trip history and earnings.
- Handles multiple taxi bookings and trip details in real-time.

## How the System Works

### 1. Booking a Taxi:
When a customer requests a taxi, the system:
- Checks the list of available taxis.
- Finds the taxi that is closest to the pickup location.
- If multiple taxis are equidistant from the pickup point, the system allocates the taxi with the lowest earnings.
- Calculates the fare and updates the taxi’s trip history.

### 2. Taxi Allocation:
The system allocates taxis based on the following criteria:
- **Distance**: Taxis that are nearest to the customer's pickup point.
- **Earnings**: Among taxis that are equidistant, the taxi with the lowest total earnings is chosen to ensure fairness.

### 3. Fare Calculation:
- The fare is calculated based on the distance between the pickup and drop points. 
- The first 5 KM has a fixed charge of 100, and every additional kilometer is charged at 10 units per KM.

### 4. Trip History:
The system records each trip and shows the following details:
- Customer ID
- Pickup and drop locations
- Pickup time
- Drop time
- Earnings from the trip

## How to Use

1. Clone the repository or copy the source files.
2. Compile and run the Java application.
3. In the main menu, you can choose:
   - **1** to book a taxi
   - **2** to view the trip details of all taxis
   - **3** to exit the application

## Example Usage

```bash
 1 --->book 
 2 --->TripDetails 
 3--->Cancel
Enter your choice: 1
Enter the Pickup Point (A-F): A
Enter the Drop Point (A-F): C
Enter the Pickup Time (8 to 24): 9

 Sample Output 

Taxi can be allotted.
Taxi-1 is allotted.

Taxi 1 Trip History:
CustomerID   Pickup   Drop     PickupTime   DropTime   Earnings   
1            A        C        9            10         120
```


## Technologies Used

- **Java**: The core programming language used for building the taxi booking system.
- **Collections API**: The `ArrayList` and `Comparator` are used to manage the list of taxis and sort them based on earnings.
- **Object-Oriented Programming (OOP)**: Classes such as `Taxi`, `Booking`, and `Trip` are used to encapsulate the data and functionality.

## Class Overview

### 1. `Taxi`
This class represents each taxi in the system and holds details like:
- **Attributes**:
  - `id`: The unique ID for each taxi.
  - `currentSpot`: The current location of the taxi.
  - `freeTime`: The time when the taxi will be available for the next trip.
  - `totalEarnings`: The total earnings of the taxi so far.
  - `tripDetails`: A list to hold the history of all trips for that taxi.
- **Methods**:
  - `updateDetails()`: Updates the taxi's location, earnings, and trip history after a booking.
  - `printTaxiDetails()`: Prints the taxi's current status.
  - `printTripHistory()`: Displays the trip history of a taxi.

### 2. `Booking`
This class handles the booking of taxis for customers and consists of:
- **Methods**:
  - `bookTaxi()`: Allocates the most suitable taxi based on distance and earnings.
  - `getAvailableTaxis()`: Finds taxis that are available for a customer at a specific pickup time and location.

## Future Enhancements

This taxi booking system can be further improved with the following features:
- **Real-time Tracking**: Implement real-time tracking of taxis to display their exact location and expected arrival time.
- **Cancel Booking**: Allow customers to cancel their bookings before the taxi arrives.
- **Pre-Booking**: Introduce an option for customers to book taxis in advance for a later time.
- **Dynamic Pricing**: Add surge pricing during peak hours to increase the fare during high demand.
- **GUI**: Develop a graphical user interface for a more interactive user experience.

## How to Contribute

1. **Fork** the repository.
2. Create a new branch with your feature or bug fix: `git checkout -b feature-branch`.
3. Commit your changes: `git commit -m 'Add a new feature'`.
4. Push to the branch: `git push origin feature-branch`.
5. Open a **Pull Request** and describe the changes you've made.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
