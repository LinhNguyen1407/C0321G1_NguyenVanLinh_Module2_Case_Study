package case_study_FuramaResort.models;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Customer implements Serializable, Comparable<Customer> {
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String guestType;
    private String address;
    private Services serviceUsage;
    private static final String NAME_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String BIRTHDAY_REGEX = "^((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((19((0[1-9])|([1-9][0-9])))|(200[0-3]))$";
    private static final String GENDER_REGEX = "^([M|m][A|a][L|l][E|e])|([F|f][E|e][M|m][A|a][L|l][E|e])|([U|u][N|n][K|k][N|n][O|o][W|w])$";
    private static final String ID_CARD_REGEX = "^\\d{3}\\s\\d{3}\\s\\d{3}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idCard, String phoneNumber, String email, String guestType, String address) throws Exception {
        boolean checkCustomer = validate(name, birthday, gender, idCard, email);
        if (!checkCustomer) {
            throw new Exception("The information entered is incorrect. Details as above. Please re-enter !");
        } else {
            this.name = name;
            this.birthday = birthday;
            this.idCard = idCard;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.guestType = guestType;
            this.address = address;
            this.gender = standardizeString(gender);
        }
    }

    public Customer(String name, String birthday, String gender, String idCard, String phoneNumber, String email, String guestType, String address, Services serviceUsage) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.guestType = guestType;
        this.address = address;
        this.serviceUsage = serviceUsage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServiceUsage() {
        return serviceUsage;
    }

    public void setServiceUsage(Services serviceUsage) {
        this.serviceUsage = serviceUsage;
    }

    private boolean validate(String name, String birthday, String gender, String idCard, String email) {
        boolean checkName = Pattern.compile(NAME_REGEX).matcher(name).matches();
        if (!checkName) {
            System.err.println("Customer's name must capitalize the first character in each word");
        }
        boolean checkBirthday = Pattern.compile(BIRTHDAY_REGEX).matcher(birthday).matches();
        if (!checkBirthday) {
            System.err.println("Birth year must be >1900 and 18 years less than current year, correct format dd/mm/yyyy");
        }
        boolean checkGender = Pattern.compile(GENDER_REGEX).matcher(gender).matches();
        if (!checkGender) {
            System.err.println("Gender must be Male, Female or Unknown");
        }
        boolean checkIdCard = Pattern.compile(ID_CARD_REGEX).matcher(idCard).matches();
        if (!checkIdCard) {
            System.err.println("Card Id must be 9 digits and in the format XXX XXX XXX");
        }
        boolean checkEmail = Pattern.compile(EMAIL_REGEX).matcher(email).matches();
        if (!checkEmail) {
            System.err.println("Email must be in the format abc@abc.abc");
        }
        return checkName && checkBirthday && checkGender && checkIdCard && checkEmail;
    }

    private static String standardizeString(String string) {
        String[] array = string.toLowerCase().split("");
        array[0] = array[0].toUpperCase();
        StringBuilder result = new StringBuilder();
        for (String element : array) {
            result.append(element);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", guestType='" + guestType + '\'' +
                ", address='" + address + '\'' +
                ", serviceUsage=" + serviceUsage +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        if (getName().equals(o.getName())) {
            String birthday1 = getBirthday();
            String birthday2 = o.getBirthday();
            String year1 = birthday1.substring(birthday1.length() - 4);
            String year2 = birthday2.substring(birthday2.length() - 4);
            return year1.compareTo(year2);
        } else {
            return getName().compareTo(o.getName());
        }
    }
}
