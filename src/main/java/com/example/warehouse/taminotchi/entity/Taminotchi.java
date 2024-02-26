package com.example.warehouse.taminotchi.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.common.exception.CustomException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Taminotchi extends AbsClass {

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String phoneNumber;




    private boolean validateField(String fieldValue, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(fieldValue);
        return matcher.matches();
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        }else {
        throw new CustomException("name entered in incorrect format");

    }}

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println("Phone number is valid.");
            this.phoneNumber=phoneNumber;
        } else {
            throw new CustomException("phoneNumber entered in incorrect format");
        }
    }


    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "^(\\d{2}\\d{3}\\d{2}\\d{2})$";
        return validateField(phoneNumber, phoneNumberPattern);
    }

    private boolean isValidName(String name) {
        // Name uchun regex pattern
        String namePattern = "^[A-Za-z\\s]{1,50}$"; // Harflar va probellar, 1 dan 50 gacha
        return validateField(name, namePattern);
    }


}
