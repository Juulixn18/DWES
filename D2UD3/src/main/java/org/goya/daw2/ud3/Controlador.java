package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

	@GetMapping("/pagina1")
	public String pagina1(HttpSession session, Model model) {
		String usuario = (String) session.getAttribute("usuarioLogueado");

		if (usuario == null) {
			return "redirect:/login";
		}

		model.addAttribute("usuario", usuario);
		model.addAttribute("pagina", "Pagina 1");
		return "pagina";
	}

	@GetMapping("/pagina2")
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
		if (session.getAttribute("usuarioLogueado") != null) {
			return "redirect:/";
		}

		model.addAttribute("datosLogin", new Usuario());
		return "login";
	}

	@PostMapping("/login")
	public String procesarLogin(@Valid @ModelAttribute("datosLogin") Usuario datosLogin, BindingResult bindingResult,
			HttpSession session, Model model) {

		// 1. Si hay errores de formato/campos vacíos, volvemos al formulario
		if (bindingResult.hasErrors()) {
			return "login";
		}

		// 2. Si el formato es válido, comprobamos credenciales
		if (USUARIO_VALIDO.equals(datosLogin.getUsuario()) && PASSWORD_VALIDA.equals(datosLogin.getPassword())) {
			session.setAttribute("usuarioLogueado", datosLogin.getUsuario());
			return "redirect:/";
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