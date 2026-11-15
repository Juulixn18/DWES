package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;

public class ThirdForm {

    @NotEmpty(message = "Debes seleccionar al menos un extra")
    private List<String> extras;


    public List<String> getExtras() {
    	return extras; 
    	}
    public void setExtras(List<String> extras) {
    	this.extras = extras; 
    	}

    @Override
    public String toString() {
        return "Extras: " + String.join(" / ", extras);
    }
}