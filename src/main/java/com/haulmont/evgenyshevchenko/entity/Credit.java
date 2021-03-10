package com.haulmont.evgenyshevchenko.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "limit")
    @Min(value = 10000, message = "Введите значение не менеее 10_000")
    @Max(value = 10000000, message = "Введите значение не более 10_000_000")
    private int limit;

    @Column(name = "percent")
    @Min(value = 1, message = "Введите значение не менеее 1")
    @Max(value = 50, message = "Введите значение не более 50")
    private int percent;

    public Credit() {
    }

    public Credit(int limit, int percent) {
        this.limit = limit;
        this.percent = percent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }


}
