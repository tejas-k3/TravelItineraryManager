package src;
import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;
    public Destination() {
        this.activities = new ArrayList<>();
    }

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activitiy) {
        if (this.activities == null) {
            this.activities = new ArrayList<>();
        }
        this.activities.add(activitiy);
    }

}
