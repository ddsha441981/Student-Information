package com.codewithcup.studentinfo.student;

import java.util.UUID;

public class Student {
    private  UUID stdId;
    private  String stdName;
    private  String stdEmail;
    private  Gender gender;

    public Student(String format) {
    }


    enum Gender {
        MALE,FEMALE
    }

    //Constructor
    public Student(UUID stdId, String stdName, String stdEmail, Gender gender) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdEmail = stdEmail;
        this.gender = gender;
    }

    public UUID getStdId() {
        return stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setStdId(UUID stdId) {
        this.stdId = stdId;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
