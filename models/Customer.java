package case_study_FuramaResort.models;

import java.io.Serializable;

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

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idCard, String phoneNumber, String email, String guestType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.guestType = guestType;
        this.address = address;
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
