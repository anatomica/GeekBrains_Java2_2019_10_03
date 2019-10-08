package lesson1.Homework;

class Participants {

    private String Name;
    private int DistanceRun;
    private double DistanceJump;

    Participants (String Name, int DistanceRun, double DistanceJump) {
        this.Name = Name;
        this.DistanceRun = DistanceRun;
        this.DistanceJump = DistanceJump;
    }

    String getName() {
        return Name;
    }
    int getDistanceRun() {
        return DistanceRun;
    }
    double getDistanceJump() {
        return DistanceJump;
    }
}
