package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotNull;

public class SecondForm {

	@NotNull(message = "Debes seleccionar un tipo de entrada")
	private String tipoEntrada;

	

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	@Override
	public String toString() {
		return "Entrada: " + tipoEntrada;
	}
}