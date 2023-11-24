package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.ServicioRepository;

public class ServicioController {

    private ServicioRepository ser;

    public ServicioRepository getSer() {
        return ser;
    }

    public ServicioController() {
        this.ser = new ServicioRepository();
    }

    public void setSer(ServicioRepository ser) {
        this.ser = ser;
    }
}
