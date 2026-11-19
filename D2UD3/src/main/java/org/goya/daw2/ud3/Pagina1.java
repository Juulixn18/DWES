package org.goya.daw2.ud3;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Pagina1 {
	
	@NotBlank
	private String usuario;
	@NotBlank
	@Min(value = 8, message = "Debe contener al menos 8 caracteres")
	private String password;
	
	
	public void seUsuario(String usuario) {
		this.usuario=usuario;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getPassword() {
		return password;
	}
}
