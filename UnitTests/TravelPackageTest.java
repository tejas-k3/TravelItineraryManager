package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import src.*;
public class TravelPackageTest {
    private TravelPackage travelPackage;
    private Destination destination;
    private Activity activity;
    private Passenger passenger;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        travelPackage = new TravelPackage("Package A", 10);
        destination = new Destination("Bali");
        activity = new Activity("Exciting ride", 100, 20);
        passenger = new Passenger("John Doe", 12345, PassengerType.GOLD, 100);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Package A", travelPackage.getName());
    }

    @Test
    public void testGetPassengerCapacity() {
        Assertions.assertEquals(10, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testGetItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Somalia"));
        itinerary.add(new Destination("Delhi"));
        travelPackage.setItinerary(itinerary);
        Assertions.assertEquals(itinerary, travelPackage.getItinerary());
    }

    @Test
    public void testSetItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Somalia"));
        itinerary.add(new Destination("Delhi"));
        travelPackage.setItinerary(itinerary);
        Assertions.assertEquals(2, travelPackage.getItinerary().size());
    }

    @Test
    public void testGetPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("First", 1, PassengerType.GOLD, 100));
        passengers.add(new Passenger("Second", 2, PassengerType.STANDARD, 300));
        for(Passenger passenger:passengers) {
            travelPackage.addPassenger(passenger);
        }
        Assertions.assertEquals(2, travelPackage.getPassengers().size());
    }

    @Test
    public void testAddDestination() {
        travelPackage.addDestination(destination);
        Assertions.assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testAddPassenger() {
        travelPackage.addPassenger(passenger);
        Assertions.assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testPrintItinerary() {
        // Add destinations and activities to the travel package
        destination.setName("Destination A");
        activity.setName("Activity A");
        activity.setDescription("Activity description");
        activity.setPrice(50);
        activity.setCapacity(20);
        destination.getActivities().add(activity);
        travelPackage.addDestination(destination);

        // Redirect System.out to outputStream
        System.setOut(new PrintStream(outputStream));

        // Call the printItinerary method
        travelPackage.printItinerary();

        // Restore System.out
        System.setOut(originalOut);

        // Verify the expected console output
        String consoleOutput = outputStream.toString();
        Assertions.assertTrue(consoleOutput.contains("Travel Itinerary for Package A:"));
        Assertions.assertTrue(consoleOutput.contains("Destination: Destination A"));
        Assertions.assertTrue(consoleOutput.contains("Activity: Activity A"));
        Assertions.assertTrue(consoleOutput.contains("Description: Activity description"));
        Assertions.assertTrue(consoleOutput.contains("Price: 50"));
        Assertions.assertTrue(consoleOutput.contains("Capacity: 20"));
    }

    @Test
    public void testActivitySignup_Successful() {
        // Add a destination and activity to the travel package
        travelPackage.addDestination(destination);
        destination.addActivity(activity);

        // Add the passenger to the travel package
        travelPackage.addPassenger(passenger);

        // Call the activitySignup method
        travelPackage.activitySignup(passenger, activity);

        // Verify that the passenger is signed up for the activity
        List<Activity> signedUpActivities = passenger.getSignedUpActivities();
        Assertions.assertTrue(signedUpActivities.contains(activity));

        // Verify that the passenger's balance is updated correctly
        Assertions.assertEquals(0, passenger.getBalance());

        // Verify that the activity's capacity is updated correctly
        Assertions.assertEquals(19, activity.getCurrentCapacity());
    }

    @Test
    public void testActivitySignup_BalanceExceeded() {
        // Add a destination and activity to the travel package
        travelPackage.addDestination(destination);
        destination.addActivity(activity);

        // Add the passenger to the travel package
        travelPackage.addPassenger(passenger);

        // Set the passenger's balance lower than the activity price
        passenger.setBalance(40);

        // Call the activitySignup method
        travelPackage.activitySignup(passenger, activity);

        // Verify that the passenger is not signed up for the activity
        List<Activity> signedUpActivities = passenger.getSignedUpActivities();
        Assertions.assertFalse(signedUpActivities.contains(activity));

        // Verify that the passenger's balance remains unchanged
        Assertions.assertEquals(40, passenger.getBalance());

        // Verify that the activity's capacity remains unchanged
        Assertions.assertEquals(20, activity.getCurrentCapacity());
    }

    @Test
    public void testActivitySignup_CapacityFull() {
        // Add a destination and activity to the travel package
        travelPackage.addDestination(destination);
        destination.addActivity(activity);

        Passenger passengerTemp = new Passenger("Passenger Temp", 999, PassengerType.STANDARD, 80);
        // Add the maximum number of passengers to the travel package
        for (int i = 1; i <= 10; i++) {
            Passenger passenger = new Passenger("Passenger " + i, i, PassengerType.STANDARD, 80);
            travelPackage.addPassenger(passenger);
        }

        // Call the activitySignup method for an additional passenger
        travelPackage.activitySignup(passengerTemp, activity);

        // Verify that the passenger is not signed up for the activity
        List<Activity> signedUpActivities = passengerTemp.getSignedUpActivities();
        Assertions.assertFalse(signedUpActivities.contains(activity));

        // Verify that the passenger's balance remains unchanged
        Assertions.assertEquals(80, passengerTemp.getBalance());

        // Verify that the activity's capacity remains unchanged
        Assertions.assertEquals(20, activity.getCurrentCapacity());
    }

}
