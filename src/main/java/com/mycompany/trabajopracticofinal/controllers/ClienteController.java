package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.ClienteRepository;

public class ClienteController {

    private ClienteRepository clir;

    public ClienteRepository getClir() {
        return clir;
    }

    public ClienteController() {this.clir = new ClienteRepository();}

    public void setClir(ClienteRepository clir) {this.clir = clir;}
}
