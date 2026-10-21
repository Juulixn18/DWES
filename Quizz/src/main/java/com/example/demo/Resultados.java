package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Resultados {
	private List<String> datos = new ArrayList<>();

	public Resultados() {
	}

	public Resultados(List<String> datos) {
		this.datos = datos;
	}

	public List<String> getDatos() {
		return datos;
	}

	public void setDatos(List<String> datos) {
		this.datos = datos;
	}
}