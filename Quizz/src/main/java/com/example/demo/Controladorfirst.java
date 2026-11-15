package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class Controladorfirst {

    @GetMapping("/firstForm")
    public String mostrarFirst(Model modelo, HttpSession session) {
        // Limpiamos cualquier sesión previa al iniciar el cuestionario
        session.invalidate();
        modelo.addAttribute("firstForm", new FirstForm());
        return "firstForm";
    }

    @PostMapping("/firstForm")
    public String procesarFirst(@Valid @ModelAttribute FirstForm first, BindingResult resultadoValido, 
                                Model modelo, HttpSession session) {
        if (resultadoValido.hasErrors()) {
            System.err.println("Error de validacion en paso 1");
            return "firstForm";
        }
        List<String> datos = new ArrayList<>();
        datos.add(first.toString());
        
        // Guardamos la lista en la sesión del servidor
        session.setAttribute("datos", datos);

        modelo.addAttribute("secondForm", new SecondForm());
        return "secondForm";
    }

    @PostMapping("/secondForm")
    public String procesarSecond(@Valid @ModelAttribute SecondForm second, BindingResult resultadoValido, 
                                 Model modelo, HttpSession session) {
        if (resultadoValido.hasErrors()) {
            System.err.println("Error de validacion en paso 2");
            return "secondForm";
        }
        // Recuperamos la lista guardada en la sesión
        List<String> datos = (List<String>) session.getAttribute("datos");
        if (datos == null) {
            datos = new ArrayList<>();
        }
        datos.add(second.toString());
        session.setAttribute("datos", datos);

        modelo.addAttribute("thirdForm", new ThirdForm());
        return "thirdForm";
    }

    @PostMapping("/thirdForm")
    public String procesarThrid(@Valid @ModelAttribute ThirdForm third, BindingResult resultadoValido, 
                                Model modelo, HttpSession session) {
        if (resultadoValido.hasErrors()) {
            System.err.println("Error de validacion en paso 3");
            return "thirdForm";
        }
        List<String> datos = (List<String>) session.getAttribute("datos");
        if (datos == null) {
            datos = new ArrayList<>();
        }
        datos.add(third.toString());
        session.setAttribute("datos", datos);

        modelo.addAttribute("fourthForm", new FourthForm());
        return "fourthForm";
    }

    @PostMapping("/resultados")
    public String procesarFourthForm(@Valid @ModelAttribute FourthForm fourth, BindingResult resultadoValido, 
                                     Model modelo, HttpSession session) {
        if (resultadoValido.hasErrors()) {
            System.err.println("Error de validacion en paso 4");
            return "fourthForm";
        }
        List<String> datos = (List<String>) session.getAttribute("datos");
        if (datos == null) {
            datos = new ArrayList<>();
        }
        datos.add(fourth.toString());

        modelo.addAttribute("resultados", new Resultados(datos));
        
        // Eliminamos el atributo de sesión al finalizar
        session.removeAttribute("datos");
        return "resultados";
    }
}