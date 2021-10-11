package com.example.Cuckoo;

public class Person {
    String name;
    String course;
    String email;
    String urlOfAvatar;

    public Person()
    {

    }

    public Person(String name, String course, String email, String urlOfAvatar) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.urlOfAvatar = urlOfAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlOfAvatar() {
        return urlOfAvatar;
    }

    public void setUrlOfAvatar(String urlOfAvatar) {
        this.urlOfAvatar = urlOfAvatar;
    }
}
