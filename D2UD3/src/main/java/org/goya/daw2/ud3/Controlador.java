package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {

    private static final String USUARIO_VALIDO = "Julian1234";
    private static final String PASSWORD_VALIDA = "Julian1234";

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

    @GetMapping({"/pagina1", "/página1"})
    public String pagina1(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("pagina", "Pagina 1");
        return "pagina";
    }

    @GetMapping({"/pagina2", "/página2"})
    public String pagina2(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("pagina", "Pagina 2");
        return "pagina";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model) {
        String usuario = (String) session.getAttribute("usuarioLogueado");

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("pagina", "Inicio");
            return "pagina";
        }

        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String usuario, @RequestParam String password, HttpSession session, Model model) {
        if (USUARIO_VALIDO.equals(usuario) && PASSWORD_VALIDA.equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            model.addAttribute("usuario", usuario);
            model.addAttribute("pagina", "Inicio");
            return "pagina";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}