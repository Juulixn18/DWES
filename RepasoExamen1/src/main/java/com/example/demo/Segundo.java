package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class Segundo {
	
	private List <String> datos= new ArrayList<>();
	
	@Email
	@NotNull(message="Escribe el correo")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public List<String> getDatos() {
		return datos;
	}

	public void setDatos(List<String> datos) {
		this.datos = datos;
	}
	public String toString() {
		return "Email: "+email;
	}
	
	
}
