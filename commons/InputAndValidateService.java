package case_study_FuramaResort.commons;

import java.util.Scanner;

public class InputAndValidateService {
    private static final String VILLA_CODE_REGEX = "^SVVL-[0-9]{4}$";
    private static final String HOUSE_CODE_REGEX = "^SVHO-[0-9]{4}$";
    private static final String ROOM_CODE_REGEX = "^SVRO-[0-9]{4}$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]+[0-9]*$";
    private static final String RENTAL_TYPE_REGEX = "^[A-Z][a-z]{1,}$";
    private static final String ROOM_STANDARD_REGEX = "^[A-Z][a-z]{1,}$";
    private static final String FREE_SERVICE_REGEX = "^(massage|karaoke|food|drink|car)$";

    static Scanner input = new Scanner(System.in);
    public static String inputVillaId() {
        while (true) {
            try {
                System.out.println("Enter id: ");
                String id = input.nextLine();
                boolean checkVillaId = id.matches(VILLA_CODE_REGEX);
                if (!checkVillaId) {
                    throw new ServiceException("Service code has the format: SVXX-YYYY, where YYYY is the numbers from 0-9, XX is VL");
                }
                return id;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputHouseId() {
        while (true) {
            try {
                System.out.println("Enter id: ");
                String id = input.nextLine();
                boolean checkHouseId = id.matches(HOUSE_CODE_REGEX);
                if (!checkHouseId) {
                    throw new ServiceException("Service code has the format: SVXX-YYYY, where YYYY is the numbers from 0-9, XX is HO");
                }
                return id;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputRoomId() {
        while (true) {
            try {
                System.out.println("Enter id: ");
                String id = input.nextLine();
                boolean checkRoomId = id.matches(ROOM_CODE_REGEX);
                if (!checkRoomId) {
                    throw new ServiceException("Service code has the format: SVXX-YYYY, where YYYY is the numbers from 0-9, XX is RO");
                }
                return id;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputServiceName() {
        while (true) {
            try {
                System.out.println("Enter serviceName: ");
                String serviceName = input.nextLine();
                boolean checkServiceName = serviceName.matches(SERVICE_NAME_REGEX);
                if (!checkServiceName) {
                    throw new ServiceException("Service name must capitalize the first letter, the following characters are lowercase");
                }
                return serviceName;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static double inputUsableArea() {
        while (true) {
            try {
                System.out.println("Enter usableArea: ");
                double usableArea = Double.parseDouble(input.nextLine());
                boolean checkUsableArea = usableArea > 30;
                if (!checkUsableArea) {
                    throw new ServiceException("The usable area must be more than 30");
                }
                return usableArea;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static double inputRentalCosts() {
        while (true) {
            try {
                System.out.println("Enter rentalCosts: ");
                double rentalCosts = Double.parseDouble(input.nextLine());
                boolean checkRentalCosts = rentalCosts > 0;
                if (!checkRentalCosts) {
                    throw new ServiceException("Rental cost must be greater than 0");
                }
                return rentalCosts;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static int inputMaxNumberPeople() {
        while (true) {
            try {
                System.out.println("Enter maxNumberPeople: ");
                int maxNumberPeople = Integer.parseInt(input.nextLine());
                boolean checkMaxNumberPeople = maxNumberPeople > 0 && maxNumberPeople < 20;
                if (!checkMaxNumberPeople) {
                    throw new ServiceException("The maximum number of people must be greater than 0 and less than 20");
                }
                return maxNumberPeople;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputRentalType() {
        while (true) {
            try {
                System.out.println("Enter rentalType: ");
                String rentalType = input.nextLine();
                boolean checkRentalType = rentalType.matches(RENTAL_TYPE_REGEX);
                if (!checkRentalType) {
                    throw new ServiceException("Rental type must capitalize the first letter, the following characters are lowercase");
                }
                return rentalType;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputRoomStandard() {
        while (true) {
            try {
                System.out.println("Enter roomStandard: ");
                String roomStandard = input.nextLine();
                boolean checkRoomStandard = roomStandard.matches(ROOM_STANDARD_REGEX);
                if (!checkRoomStandard) {
                    throw new ServiceException("Room standard must capitalize the first letter, the following characters are lowercase");
                }
                return roomStandard;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static double inputPoolArea() {
        while (true) {
            try {
                System.out.println("Enter poolArea: ");
                double poolArea = Double.parseDouble(input.nextLine());
                boolean checkPoolArea = poolArea > 30;
                if (!checkPoolArea) {
                    throw new ServiceException("Pool area must be more than 30");
                }
                return poolArea;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static int inputNumFloors() {
        while (true) {
            try {
                System.out.println("Enter numFloors: ");
                int numFloors = Integer.parseInt(input.nextLine());
                boolean checkNumFloors = numFloors > 0;
                if (!checkNumFloors) {
                    throw new ServiceException("The number of floors must be greater than 0");
                }
                return numFloors;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputFreeService() {
        while (true) {
            try {
                System.out.println("Enter freeService: ");
                String freeService = input.nextLine();
                boolean checkFreeService = freeService.matches(FREE_SERVICE_REGEX);
                if (!checkFreeService) {
                    throw new ServiceException("Free service included massage or karaoke or food or drink or car");
                }
                return freeService;
            } catch (ServiceException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
