package com.haulmont.evgenyshevchenko.service;

import com.haulmont.evgenyshevchenko.entity.Credit;

import java.util.List;

public interface CreditService {

    public List<Credit> getAllCredit();

    public void saveCredit(Credit credit);

    public Credit getCredit(String id);

    void deleteCredit(String id);
}
