package discoverCars;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;

public class Driver {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String countyCode;
    private String phoneNumber;
    private LocalDate birthDay;

    public Driver() {
    }

    public Driver(String title, String firstName, String lastName, String email, String countyCode, String phoneNumber,
                  LocalDate birthDay) {

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email.equals("random") ? RandomStringUtils.randomAlphabetic(10) + "@gmail.com" : email;
        this.countyCode = countyCode.equals("random") ? "+" + RandomStringUtils.randomNumeric(3) : countyCode;
        this.phoneNumber = phoneNumber.equals("random") ? RandomStringUtils.randomNumeric(8) : phoneNumber;
        this.birthDay = birthDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
