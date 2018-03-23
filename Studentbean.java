package com.example.user.databasestud;

import java.io.Serializable;

/**
 * Created by user on 2/17/2018.
 */

public class Studentbean {
    String Roll,name,course,email,phone;
    public String toString()
    {
        return Roll+" "+name+" "+course+" "+email+" "+phone;
    }

    public Studentbean(String name, String course, String email, String phone) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.phone = phone;
    }

   /* public Studentbean(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
*/
    public Studentbean(String roll, String name, String course, String email, String phone) {
       this.Roll = roll;
        this.name = name;
        this.course = course;
        this.email = email;
        this.phone = phone;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
