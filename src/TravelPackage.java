package src;
import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return this.itinerary;
    }

    public void setItinerary(List<Destination> itineraries) {
        this.itinerary = itineraries;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void addDestination(Destination destination) {
        this.itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if(this.passengerCapacity>0)
        {
            this.passengers.add(passenger);
            this.passengerCapacity--;
        }
    }

    public void printItinerary() {
        System.out.println("Travel Itinerary for " + this.name + ":");
        for (Destination destination : this.itinerary) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            for (Activity activity : activities) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Price: " + activity.getPrice());
                System.out.println("Capacity: " + activity.getCapacity());
            }
            System.out.println("-------------------------");
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for " + this.name + ":");
        System.out.println("Passenger Capacity: " + this.passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + this.passengers.size());
        for (Passenger passenger : this.passengers) {
            System.out.println("Name: " + passenger.getName());
            System.out.println("Number: " + passenger.getNumber());
            System.out.println("-------------------------");
        }
    }

    public void printPassengerDetail(Passenger passenger) {
        System.out.println("Passenger Details for " + passenger.getName() + ":");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Number: " + passenger.getNumber());
        if (passenger.getType() != PassengerType.PREMIUM) {
            System.out.println("Balance: " + passenger.getBalance());
        }
        List<Activity> signedUpActivities = passenger.getSignedUpActivities();
        if (signedUpActivities.size() > 0) {
            System.out.println("Activities Signed Up:");
            for (Activity activity : signedUpActivities) {
                System.out.println("Activity: " + activity.getName());
                Destination destination = this.getActivityDestination(activity);
                System.out.println("Destination: " + destination.getName());
                if (passenger.getType() != PassengerType.PREMIUM) {
                    System.out.println("Paid Price: " + this.calculatePaidPrice(activity, passenger.getType()));

                }
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No Activities Signed Up.");
        }
    }
    public void activitySignup(Passenger passenger, Activity activity) {
        int activityPrice = activity.getPrice();
        if(!passenger.isBalanceExceeded(activityPrice)&&!activity.isCapacityFull())
        {
            // Adding activity to passenger's signed ones.
            passenger.addActivity(activity);
            // Updating the passenger's balance
            passenger.updateBalance(-activityPrice);
            // Updating the activity's capacity.
            activity.setCurrentCapacity(activity.getCurrentCapacity()-1);
        }
    }

    private Destination getActivityDestination(Activity activity) {
        for (Destination destination : this.itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination;
            }
        }
        return null;
    }

    private int calculatePaidPrice(Activity activity, PassengerType passengerType) {
        int activityPrice = activity.getPrice();
        if (passengerType.equals(PassengerType.GOLD)) {
            double discountedPrice = activityPrice * 0.9;
            int priceToPay = (int) discountedPrice;
            return priceToPay;
        }
        return activityPrice;
    }

    public void printAllActivities() {
        System.out.println("Available Activities for " + this.name + ":");
        for (Destination destination : this.itinerary) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            for (Activity activity : activities) {
                if (activity.getCurrentCapacity() < activity.getCapacity()) {
                    int availableSpaces = activity.getCapacity() - activity.getCurrentCapacity();
                    System.out.println("Activity: " + activity.getName());
                    System.out.println("Description: " + activity.getDescription());
                    System.out.println("Price: " + activity.getPrice());
                    System.out.println("Available Spaces: " + availableSpaces);
                    System.out.println("-------------------------");
                }
            }
        }
    }
}
