package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import src.*;
public class PassengerTest {
    private Passenger goldPassenger;
    private Passenger premiumPassenger;

    @BeforeEach
    public void setUp() {
        goldPassenger = new Passenger("John Doe", 12345, PassengerType.GOLD, 100);
        premiumPassenger = new Passenger("John Deer", 22, PassengerType.PREMIUM, 0);

    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("John Doe", goldPassenger.getName());
    }

    @Test
    public void testSetName() {
        goldPassenger.setName("Jane Smith");
        Assertions.assertEquals("Jane Smith", goldPassenger.getName());
    }

    @Test
    public void testGetNumber() {
        Assertions.assertEquals(12345, goldPassenger.getNumber());
    }

    @Test
    public void testSetNumber() {
        goldPassenger.setNumber(67890);
        Assertions.assertEquals(67890, goldPassenger.getNumber());
    }

    @Test
    public void testGetType() {
        Assertions.assertEquals(PassengerType.GOLD, goldPassenger.getType());
    }

    @Test
    public void testSetType() {
        goldPassenger.setType(PassengerType.PREMIUM);
        Assertions.assertEquals(PassengerType.PREMIUM, goldPassenger.getType());
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(100, goldPassenger.getBalance());
    }

    @Test
    public void testSetBalance() {
        goldPassenger.setBalance(200);
        Assertions.assertEquals(200, goldPassenger.getBalance());
    }

    @Test
    public void testUpdateBalance() {
        goldPassenger.setBalance(200);
        goldPassenger.updateBalance(-10);
        Assertions.assertEquals(190, goldPassenger.getBalance());
    }

    @Test
    public void testisBalanceExceededTrueGold() {
        goldPassenger.setBalance(200);
        int price = 1000;

        Assertions.assertTrue(goldPassenger.isBalanceExceeded(price));
    }
    @Test
    public void testisBalanceExceededFalseGold() {
        goldPassenger.setBalance(180);
        int price = 200;

        Assertions.assertFalse(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testisBalanceExceededTrueStandard() {
        goldPassenger.setBalance(200);
        int price = 1000;
        Assertions.assertTrue(goldPassenger.isBalanceExceeded(price));
    }
    @Test
    public void testisBalanceExceededFalseStandard() {
        goldPassenger.setBalance(200);
        int price = 200;
        Assertions.assertFalse(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testisBalanceExceededFalsePremium() {
        int price = 100;
        Assertions.assertFalse(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testGetSignedUpActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Running", 100, 10));
        activities.add(new Activity("Walking", 100, 35));
        for(Activity activity:activities) {
            goldPassenger.addActivity(activity);
        }
        Assertions.assertEquals(2, goldPassenger.getSignedUpActivities().size());
    }

}
