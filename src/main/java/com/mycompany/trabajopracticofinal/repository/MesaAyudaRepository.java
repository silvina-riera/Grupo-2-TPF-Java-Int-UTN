package com.mycompany.trabajopracticofinal.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MesaAyudaRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
