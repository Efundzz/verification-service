package com.efundzz.verificationservice.model.SignzyDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecentroPersonalInfo {
    private DecentroName name;
    private String dateOfBirth;
    private String gender;
    private DecentroAge age;

    public DecentroName getName() {
        return name;
    }

    public void setName(DecentroName name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DecentroAge getAge() {
        return age;
    }

    public void setAge(DecentroAge age) {
        this.age = age;
    }
}
