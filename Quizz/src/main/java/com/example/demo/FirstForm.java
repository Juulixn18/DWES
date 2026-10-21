package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FirstForm {
	@NotNull
	@Size(min=2,max=20 )

	private String nombre;
	
	@NotNull
	@Min(18)
	private Integer años;
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public Integer getAños() {
		return años;
	}
	public void setAños(Integer años) {
		this.años=años;
		
	}
	
	@Override
	public String toString() {
	    return "Persona: nombre " + nombre + " - edad " + años;
	}
	
}
