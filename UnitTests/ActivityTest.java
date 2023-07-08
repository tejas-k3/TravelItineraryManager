package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.*;
public class ActivityTest {
    private Activity activity;

    @BeforeEach
    public void setUp() {
        activity = new Activity("Filler", 100, 20);
    }

    @Test
    public void testGetName() {
        activity.setName("Hiking");
        Assertions.assertEquals("Hiking", activity.getName());
    }

    @Test
    public void testSetName() {
        activity.setName("Hiking");
        Assertions.assertEquals("Hiking", activity.getName());
    }

    @Test
    public void testGetDescription() {
        activity.setDescription("Outdoor adventure");
        Assertions.assertEquals("Outdoor adventure", activity.getDescription());
    }

    @Test
    public void testSetDescription() {
        activity.setDescription("Outdoor adventure");
        Assertions.assertEquals("Outdoor adventure", activity.getDescription());
    }

    @Test
    public void testGetPrice() {
        activity.setPrice(50);
        Assertions.assertEquals(50, activity.getPrice());
    }

    @Test
    public void testSetPrice() {
        activity.setPrice(50);
        Assertions.assertEquals(50, activity.getPrice());
    }

    @Test
    public void testGetCapacity() {
        activity.setCapacity(10);
        Assertions.assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        activity.setCapacity(10);
        Assertions.assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testGetCurrentCapacity() {
        activity.setCurrentCapacity(5);
        Assertions.assertEquals(5, activity.getCurrentCapacity());
    }

    @Test
    public void testSetCurrentCapacity() {
        activity.setCurrentCapacity(5);
        Assertions.assertEquals(5, activity.getCurrentCapacity());
    }
    @Test
    public void testisCapacityFull() {
        activity.setCurrentCapacity(0);
        activity.setCapacity(5);
        Assertions.assertTrue(activity.isCapacityFull());
    }

}
