package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	private List<String>datos=new ArrayList<>();
	
	
	public Resultado(List<String> datos) {
		this.datos=datos;
	}
	public void setResultados(List <String> datos) {
		this.datos=datos;
	}
	public List<String> getDatos(){
		return datos;
	}
}
