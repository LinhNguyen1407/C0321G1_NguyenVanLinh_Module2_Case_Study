package case_study_FuramaResort.models;

import java.io.Serializable;

public abstract class Services implements Serializable {
    private String id;
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maxNumberPeople;
    private String rentalType;
    ;

    public Services() {
    }

    public Services(String id, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxNumberPeople = maxNumberPeople;
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return id;
    }

    public void setCodeService(String codeService) {
        this.id = codeService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberPeople() {
        return maxNumberPeople;
    }

    public void setMaxNumberPeople(int maxNumberPeople) {
        this.maxNumberPeople = maxNumberPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberPeople=" + maxNumberPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
