package com.haulmont.evgenyshevchenko.dao;

import com.haulmont.evgenyshevchenko.entity.Clients;

import java.util.List;

public interface ClientsDAO {
    public List<Clients> getAllClients();

    public void saveClients(Clients clients);

    public Clients getClients(String id);

    public void deleteClients(String id);
}
