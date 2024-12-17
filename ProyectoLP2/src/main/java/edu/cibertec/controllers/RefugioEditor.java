package edu.cibertec.controllers;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

import edu.cibertec.models.Refugios;
import edu.cibertec.services.RefugiosService;

public class RefugioEditor extends PropertyEditorSupport {

    private final RefugiosService refugiosService;

    public RefugioEditor(RefugiosService refugiosService) {
        this.refugiosService = refugiosService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long id = Long.parseLong(text);
        Optional<Refugios> refugio = refugiosService.findById(id);
        setValue(refugio.orElse(null));
    }
}
