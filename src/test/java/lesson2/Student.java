package lesson2;

public class Student {
    //---------Attributes--------------
    private String firstName;
    private String lastName;
    private int age;
    private String personalCode;
    private String course;

    //---------Getters/Setters---------
    public Student(
            String firstName,
            String lastname,
            int age,
            String personalCode,
            String course
    ) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.age = age;
        this.personalCode = personalCode;
        this.course = course;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
