package case_study_FuramaResort.models;

public class Room extends Services {
    private String freeServices;

    public Room() {
    }

    public Room(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String freeServices) {
        super(id, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Room{" +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
