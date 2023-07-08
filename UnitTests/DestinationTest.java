package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import src.*;
public class DestinationTest {
    private Destination destination;
    private Activity activity;

    @BeforeEach
    public void setUp() {
        destination = new Destination("Filler");
        activity = new Activity("Walk", 100, 10);
    }

    @Test
    public void testGetName() {
        destination.setName("Mountain Peak");
        Assertions.assertEquals("Mountain Peak", destination.getName());
    }

    @Test
    public void testSetName() {
        destination.setName("Mountain Peak");
        Assertions.assertEquals("Mountain Peak", destination.getName());
    }

    @Test
    public void testGetActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Running", 100, 10));
        activities.add(new Activity("Walking", 100, 35));
        destination.setActivities(activities);
        Assertions.assertEquals(2, destination.getActivities().size());
    }

    @Test
    public void testSetActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Running", 100, 10));
        activities.add(new Activity("Walking", 100, 35));
        destination.setActivities(activities);
        Assertions.assertEquals(2, destination.getActivities().size());
    }

    @Test
    public void testAddActivity() {
        destination.addActivity(activity);
        Assertions.assertTrue(destination.getActivities().contains(activity));
    }
}
