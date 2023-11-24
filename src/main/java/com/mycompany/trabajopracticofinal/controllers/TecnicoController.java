package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.TecnicoRepository;

public class TecnicoController {

    private TecnicoRepository tecr;

    public TecnicoRepository geTecr() {
        return tecr;
    }

    public TecnicoController() {
        this.tecr = new TecnicoRepository();
    }

    public void setTecr(TecnicoRepository tecr) {
        this.tecr = tecr;
    }
}
