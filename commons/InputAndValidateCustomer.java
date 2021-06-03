package case_study_FuramaResort.commons;

import java.util.Scanner;

public class InputAndValidateCustomer {
    private static final String NAME_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String BIRTHDAY_REGEX = "^((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((19((0[1-9])|([1-9][0-9])))|(200[0-3]))$";
    private static final String GENDER_REGEX = "^([M|m][A|a][L|l][E|e])|([F|f][E|e][M|m][A|a][L|l][E|e])|([U|u][N|n][K|k][N|n][O|o][W|w])$";
    private static final String ID_CARD_REGEX = "^\\d{3}\\s\\d{3}\\s\\d{3}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";

    static Scanner input = new Scanner(System.in);
    public static String inputName() {
        while (true) {
            try {
                System.out.println("Enter name: ");
                String name = input.nextLine();
                boolean checkName = name.matches(NAME_REGEX);
                if (!checkName) {
                    throw new CustomerException("Customer's name must capitalize the first character in each word");
                }
                return name;
            } catch (CustomerException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputBirthday() {
        while (true) {
            try {
                System.out.println("Enter birthday: ");
                String birthday = input.nextLine();
                boolean checkBirthday = birthday.matches(BIRTHDAY_REGEX);
                if (!checkBirthday) {
                    throw new CustomerException("Birth year must be >1900 and 18 years less than current year, correct format dd/mm/yyyy");
                }
                return birthday;
            } catch (CustomerException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputGender() {
        while (true) {
            try {
                System.out.println("Enter gender: ");
                String gender = input.nextLine();
                boolean checkGender = gender.matches(GENDER_REGEX);
                if (!checkGender) {
                    throw new CustomerException("Gender must be Male, Female or Unknown");
                }
                return gender;
            } catch (CustomerException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputIdCard() {
        while (true) {
            try {
                System.out.println("Enter idCard: ");
                String idCard = input.nextLine();
                boolean checkIdCard = idCard.matches(ID_CARD_REGEX);
                if (!checkIdCard) {
                    throw new CustomerException("Card Id must be 9 digits and in the format XXX XXX XXX");
                }
                return idCard;
            } catch (CustomerException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputEmail() {
        while (true) {
            try {
                System.out.println("Enter email: ");
                String email = input.nextLine();
                boolean checkEmail = email.matches(EMAIL_REGEX);
                if (!checkEmail) {
                    throw new CustomerException("Email must be in the format abc@abc.abc");
                }
                return email;
            } catch (CustomerException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static String inputPhoneNumber() {
        System.out.println("Enter phoneNumber: ");
        return input.nextLine();
    }

    public static String inputGuestType() {
        System.out.println("Enter guestType: ");
        return input.nextLine();
    }

    public static String inputAddress() {
        System.out.println("Enter address: ");
        return input.nextLine();
    }

    public static String standardizeString(String gender) {
        String[] array = gender.toLowerCase().split("");
        array[0] = array[0].toUpperCase();
        StringBuilder result = new StringBuilder();
        for (String element : array) {
            result.append(element);
        }
        return result.toString();
    }
}
