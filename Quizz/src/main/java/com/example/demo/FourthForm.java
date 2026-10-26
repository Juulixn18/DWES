package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FourthForm {

	private List<String> datos = new ArrayList<>();

	@NotNull
	@Size(min = 10, max = 100, message = "El comentario debe tener entre 10 y 100 caracteres")
	private String comentarios;

	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {   
		this.comentarios = comentarios;
	}

	public List<String> getDatos() {
		return datos;
	}
	public void setDatos(List<String> datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "Comentario: " + comentarios;
	}
}