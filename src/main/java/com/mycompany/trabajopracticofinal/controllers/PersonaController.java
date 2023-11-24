package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.repository.PersonaRepository;

public class PersonaController {

    private PersonaRepository per;

    public PersonaRepository getPer() {
        return per;
    }

    public PersonaController() {
        this.per = new PersonaRepository();
    }

    public void setPer(PersonaRepository per) {
        this.per = per;
    }
}
