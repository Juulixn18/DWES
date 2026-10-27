package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.validation.Valid;

@Controller
public class ControladorCodificacion {

    // Muestra la página con los dos formularios (POST y GET)
    @GetMapping("/codificacion")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("codificacionForm", new CodificacionForm());
        return "codificacion";
    }

    // 1.1 Formulario por POST (con validación)
    @PostMapping("/codificacion")
    public String procesarPost(@Valid @ModelAttribute CodificacionForm form, BindingResult resultadoValido,
            Model modelo) {
        if (resultadoValido.hasErrors()) {
            System.err.println("Error de validacion");
            return "codificacion";
        }
        modelo.addAttribute("metodo", "POST");
        modelo.addAttribute("texto", form.getTexto());
        return "recibido";
    }

    // 1.2 Formulario por GET
    @GetMapping("/recibir")
	public String procesarGet(@RequestParam(name = "texto", required = false) String texto, Model modelo) {
		modelo.addAttribute("metodo", "GET");
		modelo.addAttribute("texto", texto);
		return "recibido";
	}
    //1.3
	// 3. Enlaces con query-string: sin codificar y codificados con URLEncoder
	@GetMapping("/enlaces")
	public String mostrarEnlaces(Model modelo) {
		String[] pruebas = { "áéíóú", "ñ Ñ", "\\", "/", "'", "\"", "`", "<b>negrita</b>", "&", "=", "#", "+", "%", "?",
				"hola mundo" };

		// clave = texto original, valor = texto codificado con URLEncoder
		Map<String, String> caracteres = new LinkedHashMap<>();
		for (String prueba : pruebas) {
			caracteres.put(prueba, URLEncoder.encode(prueba, StandardCharsets.UTF_8));
		}

		modelo.addAttribute("caracteres", caracteres);
		return "enlaces";
	}
}