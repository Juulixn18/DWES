package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import jakarta.validation.Valid;

@Controller
public class Controlador {
	
	
	//En el get solo el modelo y se añade el primer formulario
	@GetMapping("/primero")
	public String mostrarPrimero(Model modelo) {
		modelo.addAttribute("primero", new Primero());	
		return "primero";
		
	}
	
	@PostMapping("/primero")
	public String procesarPrimero(@Valid @ModelAttribute  Primero primero, BindingResult resultadoValido, Model modelo) {
		
		if(resultadoValido.hasErrors()) {
			System.err.println("Resultado invalido");
			return "primero";
		}
		List <String>datos=new ArrayList<>();
		modelo.addAttribute("datos", datos);
		modelo.addAttribute("segundo", new Segundo());
		return "segundo";		
	}
	
	@PostMapping("/segundo")
	public String procesarSegundo(@Valid @ModelAttribute Segundo segundo, BindingResult resultadoValido, Model modelo) {
		List <String> datos=new ArrayList<>(segundo.getDatos());
		if(resultadoValido.hasErrors()) {
			System.err.println("Resultado invalido");
			modelo.addAttribute("datos", datos);
			return "segundo";
			
		}
		datos.add(segundo.toString());
		modelo.addAttribute("datos",datos);
		modelo.addAttribute("tercero", new Tercero());
		return "tercero";
	}
	@PostMapping("/resultado")
	public String procesarTercero(@Valid @ModelAttribute Tercero tercero, BindingResult resultadoValido, Model modelo) {
		List <String> datos=new ArrayList<>(tercero.getDatos());
		if(resultadoValido.hasErrors()) {
			System.err.println("Error de validacion");
			modelo.addAttribute("datos", datos);
			return "tercero";
		}
		datos.add(tercero.toString());
		modelo.addAttribute("resultado", new Resultado());
		return "resultado";
	}
	

	
}
	

