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
public class Controladorfirst {
	
	@GetMapping("/firstForm")
	public String mostrarFirst(Model modelo) {
		modelo.addAttribute("firstForm", new FirstForm());
		return "firstForm";
	}
	
	@PostMapping("/firstForm")
	public String procesarFirst(@Valid @ModelAttribute FirstForm first, BindingResult resultadoValido, Model modelo) {
		if(resultadoValido.hasErrors()) {
			System.err.println("Error de validacion");
			return "firstForm";
		}		
		List<String> datos = new ArrayList<>();
        datos.add(first.toString());
        modelo.addAttribute("datos", datos);
        
		modelo.addAttribute("secondForm", new SecondForm());		
		return "secondForm";
	}
	@PostMapping("/secondForm")
	public String procesarSecond(@Valid @ModelAttribute SecondForm second, BindingResult resultadoValido, Model modelo) {
		List<String> datos = new ArrayList<>(second.getDatos());
		if(resultadoValido.hasErrors()) {
			System.err.println("Error de validacion");
			modelo.addAttribute("datos", datos);
			return "secondForm";
		}
		datos.add(second.toString());
		modelo.addAttribute("datos", datos);
		
		modelo.addAttribute("thirdForm", new ThirdForm());
		return "thirdForm";
	}
	@PostMapping("/resultados")
	public String procesarThrid(@Valid @ModelAttribute ThirdForm third, BindingResult resultadoValido, Model modelo) {
		List<String> datos = new ArrayList<>(third.getDatos());
		if(resultadoValido.hasErrors()) {
			System.err.println("Error de validacion");
			modelo.addAttribute("datos", datos);
			return "thirdForm";
		}
		datos.add(third.toString());

		modelo.addAttribute("resultados", new Resultados(datos));
		return "resultados";
	}
	
	
}
