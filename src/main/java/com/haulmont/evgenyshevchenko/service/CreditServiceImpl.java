package com.haulmont.evgenyshevchenko.service;

import com.haulmont.evgenyshevchenko.dao.CreditDAO;
import com.haulmont.evgenyshevchenko.entity.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDAO creditDAO;

    @Override
    @Transactional
    public List<Credit> getAllCredit() {
        return creditDAO.getAllCredit();
    }

    @Override
    @Transactional
    public void saveCredit(Credit credit) {
        creditDAO.saveCredit(credit);
    }

    @Override
    @Transactional
    public Credit getCredit(String id) {
        return creditDAO.getCredit(id);
    }

    @Override
    @Transactional
    public void deleteCredit(String id) {
        creditDAO.deleteCredit(id);
    }


}
