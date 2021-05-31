package case_study_FuramaResort.models;

import java.util.regex.Pattern;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numFloors;
    private static final String CODE_SERVICE_REGEX = "^SVVL-[0-9]{4}$";
    private static final String ROOM_STANDARD_REGEX = "^[A-Z][a-z]{1,}$";

    public Villa() {
    }

    public Villa(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, double poolArea, int numFloors) throws Exception {
        super(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        boolean checkVilla = validate(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType, roomStandard, poolArea, numFloors);
        if (!checkVilla) {
            throw new Exception("The information entered is incorrect. Notice details as above. Please re-enter !");
        } else {
            this.roomStandard = roomStandard;
            this.poolArea = poolArea;
            this.numFloors = numFloors;
        }
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

    public boolean validate(String codeService, String serviceName, double usableArea, double rentalCosts, int maxNumberPeople, String rentalType, String roomStandard, double poolArea, int numFloors) {
        boolean checkCodeService = Pattern.compile(CODE_SERVICE_REGEX).matcher(codeService).matches();
        if (!checkCodeService) {
            System.err.println("Service code has the format: SVXX-YYYY, where YYYY is the numbers from 0-9, XX is VL");
        }
        boolean checkRoomStandard = Pattern.compile(ROOM_STANDARD_REGEX).matcher(roomStandard).matches();
        if (!checkRoomStandard) {
            System.err.println("Room standard must capitalize the first letter, the following characters are lowercase");
        }
        boolean checkPoolArea = poolArea > 30;
        if (!checkPoolArea) {
            System.err.println("Pool area must be more than 30");
        }
        boolean checkNumFloors = numFloors > 0;
        if (!checkNumFloors) {
            System.err.println("The number of floors must be greater than 0");
        }
        return super.validate(serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType) && checkCodeService && checkRoomStandard && checkPoolArea && checkNumFloors;
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
