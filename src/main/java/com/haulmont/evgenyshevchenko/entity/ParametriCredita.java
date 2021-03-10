package com.haulmont.evgenyshevchenko.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


public class ParametriCredita {
    @Min(value = 10000, message = "Значение должно быть не менее 10_000")
    @Max(value = 10000000, message = "Значение должно быть не болеее 10_000_000")
    private int sumCredit;
    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Введите дату в формате dd.MM.yyyy")
    private String data;
    @Min(value = 1, message = "Значение должно быть не менее 1")
    @Max(value = 20, message = "Значение должно быть не более 20")
    private String years;

    public ParametriCredita() {
    }

    public ParametriCredita(int sumCredit, String data, String years) {
        this.sumCredit = sumCredit;
        this.data = data;
        this.years = years;
    }

    public int getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(int sumCredit) {
        this.sumCredit = sumCredit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

}
