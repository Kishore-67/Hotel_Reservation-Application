package com.example.demojavafx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty mobile;
    private final StringProperty course;

    public Student() {
        id = new SimpleIntegerProperty(this, "id");
        name = new SimpleStringProperty(this, "name");
        mobile = new SimpleStringProperty(this, "mobile");
        course = new SimpleStringProperty(this, "course");
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int newId) {
        id.set(newId);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String newName) {
        name.set(newName);
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String newMobile) {
        mobile.set(newMobile);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String newCourse) {
        course.set(newCourse);
    }
}