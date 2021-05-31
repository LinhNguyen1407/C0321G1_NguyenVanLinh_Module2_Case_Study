package case_study_FuramaResort.models;

import java.util.regex.Pattern;

public class Room extends Services {
    private String freeServices;
    private static final String CODE_SERVICE_REGEX = "^SVRO-[0-9]{4}$";

    public Room() {
    }

    public Room(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String freeServices) throws Exception {
        super(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        boolean checkRoom = validate(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        if (!checkRoom) {
            throw new Exception("The information entered is incorrect. Notice details as above. Please re-enter !");
        } else {
            this.freeServices = freeServices;
        }
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public boolean validate(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType) {
        boolean checkCodeService = Pattern.compile(CODE_SERVICE_REGEX).matcher(codeService).matches();
        if (!checkCodeService) {
            System.err.println("The service code has the format: SVXX-YYYY, where YYYY is the numbers 0-9, XX is RO");
        }
        return super.validate(serviceName,usableArea,rentalCosts,maxNumberPeople,rentalType) && checkCodeService;
    }


    @Override
    public String toString() {
        return super.toString() +
                " Room{" +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
