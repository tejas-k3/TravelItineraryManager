package src;
import java.util.ArrayList;

public class Activity {
    private String name;
    private String description;
    private int price;
    private int capacity;
    private int currentCapacity;
    public Activity(String name, int price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.currentCapacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public boolean isCapacityFull() {
        return (this.currentCapacity == 0);
    }
}
