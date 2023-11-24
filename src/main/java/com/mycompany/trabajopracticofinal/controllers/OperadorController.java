package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.OperadorRepository;

public class OperadorController {

    private OperadorRepository opr;

    public OperadorRepository getOpr() {
        return opr;
    }

    public OperadorController() {
        this.opr = new OperadorRepository();
    }

    public void setOpr(OperadorRepository opr) {
        this.opr = opr;
    }
}
