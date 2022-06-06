// This class is used to contain the information of a single Task that is created, to aid with Task object management for the greater Task class
public class TaskItem {
    private String ID;
    private int number;
    private String name;
    private int duration;
    private String status;
    private String description;
    private String developerDetails;

    public TaskItem(String name, int number, String description, String developerDetails, int duration, String status, String id) {
        this.name = name;
        this.number = number;
        this.status = status;
        this.duration = duration;
        this.description = description;
        this.developerDetails = developerDetails;
        this.ID = id;
    }



    public String getID() {
        return ID;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }
}