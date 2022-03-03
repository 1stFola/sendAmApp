package africa.semicolon.sendAm.data.models;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private int id;
    private User owner;
    private PackageDescription description;
    private final List<Status> statusList = new ArrayList<>();

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", owner=" + owner +
                ", description=" + description +
                ", statusList=" + statusList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public PackageDescription getDescription() {
        return description;
    }

    public void setDescription(PackageDescription description) {
        this.description = description;
    }

    public List<Status> getStatusList() {
        return statusList;
    }
}
