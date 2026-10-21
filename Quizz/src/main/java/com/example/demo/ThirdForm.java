package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;

public class ThirdForm {

    @NotEmpty(message = "Debes seleccionar al menos un extra")
    private List<String> extras;

    private List<String> datos = new ArrayList<>();   // datos de las etapas anteriores

    public List<String> getExtras() { return extras; }
    public void setExtras(List<String> extras) { this.extras = extras; }

    public List<String> getDatos() { return datos; }
    public void setDatos(List<String> datos) { this.datos = datos; }

    @Override
    public String toString() {
        return "Extras: " + String.join(" / ", extras);
    }
}