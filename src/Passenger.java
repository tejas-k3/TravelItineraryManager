package src;
import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int number;
    private PassengerType type;
    // BALANCE NOT APPLICABLE ON PREMIUM PASSENGER AS
    // THEY CAN SIGNUP FOR ACTIVITIES FREE OF COST
    private int balance;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int number, PassengerType type, int balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void updateBalance(int balance) {
        this.balance += balance;
    }

    public List<Activity> getSignedUpActivities() {
        return this.signedUpActivities;
    }

    public void addActivity(Activity activity) {
        signedUpActivities.add(activity);
    }

    public boolean isBalanceExceeded(int price) {
        PassengerType passengerType = this.getType();
        return passengerType.isBalanceExceeded(this.balance, price);
    }
}
