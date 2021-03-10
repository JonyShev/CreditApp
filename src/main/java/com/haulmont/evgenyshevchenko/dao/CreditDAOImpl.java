package com.haulmont.evgenyshevchenko.dao;

import com.haulmont.evgenyshevchenko.entity.Clients;
import com.haulmont.evgenyshevchenko.entity.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditDAOImpl implements CreditDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Credit> getAllCredit() {
        Session session = sessionFactory.getCurrentSession();
        List<Credit> allCredit = session.createQuery("from Credit", Credit.class)
                .getResultList();
        return allCredit;
    }

    @Override
    public void saveCredit(Credit credit) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(credit);
    }

    @Override
    public Credit getCredit(String id) {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = session.get(Credit.class, id);
        return credit;
    }

    @Override
    public void deleteCredit(String id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Clients> query = session.createQuery("delete from Credit " +
                "where id =:creditId");
        query.setParameter("creditId", id);
        query.executeUpdate();
    }
}
