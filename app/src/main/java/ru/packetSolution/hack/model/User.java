package ru.packetSolution.hack.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String user_location;
    private int salary;
    private String photo_url;
    private String user_status;
    private String registration_date;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", user_location='" + user_location + '\'' +
                ", salary=" + salary +
                ", photo_url='" + photo_url + '\'' +
                ", user_status='" + user_status + '\'' +
                ", registration_date='" + registration_date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_location() {
        return user_location;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public String getUser_status() {
        return user_status;
    }

    public String getRegistration_date() {
        return registration_date;
    }
    public User(int id, String name, String email, String phone, String password, String user_location, int salary, String photo_url, String user_status, String registration_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.user_location = user_location;
        this.salary = salary;
        this.photo_url = photo_url;
        this.user_status = user_status;
        this.registration_date = registration_date;
    }
}
