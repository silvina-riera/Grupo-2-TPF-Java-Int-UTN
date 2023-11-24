package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.EspecialidadRepository;

public class EspecialidadController {

    private EspecialidadRepository espr;

    public EspecialidadRepository getEspr() {
        return espr;
    }

    public EspecialidadController() {
        this.espr = new EspecialidadRepository();
    }

    public void setEspr(EspecialidadRepository espr) {
        this.espr = espr;
    }
}
