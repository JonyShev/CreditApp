package com.haulmont.evgenyshevchenko.dao;

import com.haulmont.evgenyshevchenko.entity.Credit;

import java.util.List;

public interface CreditDAO {
    public List<Credit> getAllCredit();

    public void saveCredit(Credit credit);

    public Credit getCredit(String id);

    public void deleteCredit(String id);
}
