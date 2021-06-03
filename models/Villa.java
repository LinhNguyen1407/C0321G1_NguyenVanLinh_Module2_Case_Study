package case_study_FuramaResort.models;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numFloors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, double poolArea, int numFloors) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numFloors = numFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numFloors=" + numFloors +
                '}';
    }
}
