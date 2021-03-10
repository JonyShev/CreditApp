package com.haulmont.evgenyshevchenko.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "fio")
    @Size(min = 2, message = "Введите хотя бы 2 символа, поле не должны быть пустым")
    @NotBlank(message = "Поле не должно быть пустым")
    private String fio;

    @Column(name = "phonenumber")
    @Pattern(regexp = "\\d{11}", message = "Номер телефона должен содержать 11 цифр")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "passportnumber")
    private int passportNumber;

    public Clients() {
    }

    public Clients(String fio, String phoneNumber, String email, int passportNumber) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
