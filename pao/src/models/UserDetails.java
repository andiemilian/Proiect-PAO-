package models;

import java.util.Objects;

public abstract class UserDetails {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String phoneNumber;

    public UserDetails() {

    }

    public UserDetails(String name, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails details = (UserDetails) o;
        return Objects.equals(name, details.name) && Objects.equals(email, details.email) && Objects.equals(phoneNumber, details.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", age: " + age +
                ", e-mail: " + email +
                ", phone number: " + phoneNumber;
    }

}
