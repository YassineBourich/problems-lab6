package challenge;

public class Town {
    private String name;
    private int distance_from_starting_pt;
    private Town starting_point;

    // Constructor for staring point
    public Town(String name) {
        this.name = name;
        this.distance_from_starting_pt = 0;
    }

    // Constructor for other towns
    public Town(String name, int distance, Town starting_town) {
        this(name);
        this.distance_from_starting_pt = distance;
        this.starting_point = starting_town;
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromStartingPoint() {
        return distance_from_starting_pt;
    }

    @Override
    public String toString() {
        if (starting_point != null)
            return "Town: " + name + " is " + distance_from_starting_pt + " km from " + starting_point.getName();

        return "Town: " + name;
    }
}
