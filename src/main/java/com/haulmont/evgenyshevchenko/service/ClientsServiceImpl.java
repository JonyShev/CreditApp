package com.haulmont.evgenyshevchenko.service;

import com.haulmont.evgenyshevchenko.dao.ClientsDAO;
import com.haulmont.evgenyshevchenko.entity.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsDAO clientsDAO;

    @Override
    @Transactional
    public List<Clients> getAllClients() {
        return clientsDAO.getAllClients();
    }

    @Override
    @Transactional
    public void saveClients(Clients clients) {
        clientsDAO.saveClients(clients);
    }

    @Override
    @Transactional
    public Clients getClients(String id) {
        return clientsDAO.getClients(id);
    }

    @Override
    @Transactional
    public void deleteClients(String id) {
        clientsDAO.deleteClients(id);
    }


}
