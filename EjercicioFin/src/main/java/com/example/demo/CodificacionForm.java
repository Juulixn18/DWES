package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CodificacionForm {

	@NotBlank(message = "El texto no puede estar vacío")
	@Size(max = 200, message = "Máximo 200 caracteres")
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Texto: " + texto;
	}
}