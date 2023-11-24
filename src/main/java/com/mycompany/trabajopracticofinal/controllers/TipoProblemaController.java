package com.mycompany.trabajopracticofinal.controllers;

import com.mycompany.trabajopracticofinal.modelo.TipoProblema;
import com.mycompany.trabajopracticofinal.repository.TipoProblemaRepository;

public class TipoProblemaController {

    private TipoProblemaRepository tipor;

    public TipoProblemaRepository getTipor() {
        return tipor;
    }

    public TipoProblemaController() {
        this.tipor = new TipoProblemaRepository();
    }

    public void setTipor(TipoProblemaRepository tipor) {
        this.tipor = tipor;
    }
}
