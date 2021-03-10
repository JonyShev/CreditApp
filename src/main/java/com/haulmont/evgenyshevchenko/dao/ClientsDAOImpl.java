package com.haulmont.evgenyshevchenko.dao;

import com.haulmont.evgenyshevchenko.entity.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientsDAOImpl implements ClientsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Clients> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Clients> allClients = session.createQuery("from Clients", Clients.class)
                .getResultList();
        return allClients;
    }

    @Override
    public void saveClients(Clients clients) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(clients);
    }

    @Override
    public Clients getClients(String id) {
        Session session = sessionFactory.getCurrentSession();
        Clients clients = session.get(Clients.class, id);
        return clients;
    }

    @Override
    public void deleteClients(String id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Clients> query = session.createQuery("delete from Clients " +
                "where id =:clientsId");
        query.setParameter("clientsId", id);
        query.executeUpdate();
    }
}
