package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {
	
	private static final String USUARIO_VALIDO="Julian1234";
	private static final String PASSWORD_VALIDA="Julian1234";
	
	@GetMapping("/")
    public String inicio(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("pagina", "Inicio");
        return "pagina";
    }
}
