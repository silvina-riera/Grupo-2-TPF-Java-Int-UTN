package com.mycompany.trabajopracticofinal.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OperadorRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
