package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.MesaAyudaRepository;

public class MesaAyudaController {

    private MesaAyudaRepository mesar;

    public MesaAyudaRepository getMesar() {
        return mesar;
    }

    public MesaAyudaController() {
        this.mesar = new MesaAyudaRepository();
    }

    public void setMesar(MesaAyudaRepository mesar) {
        this.mesar = mesar;
    }
}
