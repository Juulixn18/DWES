package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotNull;

public class SecondForm {

	@NotNull(message = "Debes seleccionar un tipo de entrada")
	private String tipoEntrada;

	private List<String> datos = new ArrayList<>(); // datos de las etapas anteriores

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public List<String> getDatos() {
		return datos;
	}

	public void setDatos(List<String> datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "Entrada: " + tipoEntrada;
	}
}