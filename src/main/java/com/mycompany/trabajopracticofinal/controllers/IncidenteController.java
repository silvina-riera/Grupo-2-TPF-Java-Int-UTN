package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.IncidenteRepository;

public class IncidenteController {

    private IncidenteRepository incr;

    public IncidenteRepository getIncr() {
        return incr;
    }

    public IncidenteController() {
        this.incr = new IncidenteRepository();
    }

    public void setIncr(IncidenteRepository incr) {
        this.incr = incr;
    }
}
