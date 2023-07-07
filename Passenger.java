import java.util.List;

public class Passenger {
    private String name;
    private int number;
    private PassengerType type;
    // BALANCE NOT APPLICABLE ON PREMIUM PASSENGER AS
    // THEY CAN SIGNUP FOR ACTIVITIES FREE OF COST
    private int balance;
    private List<Activity> signedUpActivities;

    Passenger(String name, int number, PassengerType type, int balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
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

    public List<Activity> getSignedUpActivities() {
        return this.signedUpActivities;
    }

    private void addActivity(Activity activity) {
        signedUpActivities.add(activity);
    }

    public boolean activitySignup(Activity activity) {
        int activityPrice = activity.getPrice();
        if(this.getType().equals(PassengerType.PREMIUM))
        {
            this.addActivity(activity);
            return true;
        }
        else if(this.getType().equals(PassengerType.GOLD))
        {
            double discountedPrice = activityPrice*0.9;
            int priceToPay = (int)discountedPrice;
            if(this.balance>=priceToPay)
            {
                this.balance-=priceToPay;
                this.addActivity(activity);
                return true;
            }
            return false;
        }
        else if(this.getType().equals(PassengerType.STANDARD))
        {
            if(this.balance>=activityPrice)
            {
                this.balance-=activityPrice;
                this.addActivity(activity);
                return true;
            }
        }
        return false;
    }
}
