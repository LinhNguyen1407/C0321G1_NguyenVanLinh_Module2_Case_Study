package case_study_FuramaResort.models;

import java.util.regex.Pattern;

public class House extends Services {
    private String roomStandard;
    private int numFloors;
    private static final String CODE_SERVICE_REGEX = "^SVHO-[0-9]{4}$";
    private static final String ROOM_STANDARD_REGEX = "^[A-Z][a-z]{1,}$";

    public House() {
    }

    public House(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, int numFloors) throws Exception {
        super(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        boolean checkHouse = validate(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType, roomStandard, numFloors);
        if (!checkHouse) {
            throw new Exception("The information entered is incorrect. Notice details as above. Please re-enter !");
        } else {
            this.roomStandard = roomStandard;
            this.numFloors = numFloors;
        }
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

    public boolean validate(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, int numFloors) {
        boolean checkCodeService = Pattern.compile(CODE_SERVICE_REGEX).matcher(codeService).matches();
        if (!checkCodeService) {
            System.err.println("The service code has the format: SVXX-YYYY, where YYYY is the numbers 0-9, XX is HO");
        }
        boolean checkRoomStandard = Pattern.compile(ROOM_STANDARD_REGEX).matcher(roomStandard).matches();
        if (!checkRoomStandard) {
            System.err.println("Room standard must capitalize the first letter, the following characters are lowercase");
        }
        boolean checkNumFloors = numFloors > 0;
        if (!checkNumFloors) {
            System.err.println("Number of floors must be greater than 0");
        }
        return super.validate(serviceName,usableArea,rentalCosts,maxNumberPeople,rentalType) && checkCodeService && checkRoomStandard && checkNumFloors;
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
