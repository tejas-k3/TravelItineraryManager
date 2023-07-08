import src.*;
public class Driver {
    public static void main(String[] args) {
        // Create destinations
        Destination destination1 = new Destination("Beach Paradise");

        Destination destination2 = new Destination("Mountain Retreat");

        // Create activities
        Activity activity1 = new Activity("Snorkeling Adventure", 50, 20);
        activity1.setDescription("Explore the vibrant marine life underwater");
        activity1.setCurrentCapacity(0);

        Activity activity2 = new Activity("Hiking Expedition", 75, 15);
        activity2.setDescription("Conquer the challenging mountain trails");
        activity2.setCurrentCapacity(0);

        // Add activities to destinations
        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        // Create passengers
        Passenger passenger1 = new Passenger("John Doe", 12345, PassengerType.GOLD, 100);
        Passenger passenger2 = new Passenger("Jane Smith", 67890, PassengerType.STANDARD, 50);

        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Exotic Escapes", 10);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.activitySignup(passenger1, activity1);
        travelPackage.activitySignup(passenger2, activity1);
        travelPackage.activitySignup(passenger2, activity1);

        // Print the travel itinerary
        travelPackage.printItinerary();

        // Print the passenger list
        travelPackage.printPassengerList();

        // Print passenger details
        travelPackage.printPassengerDetail(passenger1);
        travelPackage.printPassengerDetail(passenger2);

        // Print available activities
        travelPackage.printAllActivities();
    }
}
