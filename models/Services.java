package case_study_FuramaResort.models;

import java.io.Serializable;
import java.util.regex.Pattern;

public abstract class Services implements Serializable {
    private String codeService;
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private int maxNumberPeople;
    private String rentalType;
    private static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]{1,}$";
    private static final String RENTAL_TYPE_REGEX = "^[A-Z][a-z]{1,}$";
    ;

    public Services() {
    }

    public Services(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType) {
        this.codeService = codeService;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxNumberPeople = maxNumberPeople;
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
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

    public boolean validate(String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType) {
        boolean checkServiceName = Pattern.compile(SERVICE_NAME_REGEX).matcher(serviceName).matches();
        if (!checkServiceName) {
            System.err.println("Service name must capitalize the first letter, the following characters are lowercase");
        }
        boolean checkUsableArea = usableArea > 30;
        if (!checkUsableArea) {
            System.err.println("The usable area must be more than 30");
        }
        boolean checkRentalCosts = rentalCosts > 0;
        if (!checkRentalCosts) {
            System.err.println("Rental cost must be greater than 0");
        }
        boolean checkMaxNumberPeople = maxNumberPeople > 0 && maxNumberPeople < 20;
        if (!checkMaxNumberPeople) {
            System.err.println("The maximum number of people must be >0 and <20");
        }
        boolean checkRentalType = Pattern.compile(RENTAL_TYPE_REGEX).matcher(rentalType).matches();
        if (!checkRentalType) {
            System.err.println("Rental type must capitalize the first letter, the following characters are lowercase");
        }
        return checkServiceName && checkUsableArea && checkRentalCosts && checkMaxNumberPeople && checkRentalType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "codeService='" + codeService + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberPeople=" + maxNumberPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
