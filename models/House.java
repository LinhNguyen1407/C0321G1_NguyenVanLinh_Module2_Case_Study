package case_study_FuramaResort.models;

public class House extends Services {
    private String roomStandard;
    private int numFloors;

    public House() {
    }

    public House(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, int numFloors) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numFloors = numFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                " House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numFloors=" + numFloors +
                '}';
    }
}
