package com.haulmont.evgenyshevchenko.service;

import com.haulmont.evgenyshevchenko.entity.Clients;

import java.util.List;

public interface ClientsService {

    public List<Clients> getAllClients();

    public void saveClients(Clients clients);

    public Clients getClients(String id);

    void deleteClients(String id);

}
