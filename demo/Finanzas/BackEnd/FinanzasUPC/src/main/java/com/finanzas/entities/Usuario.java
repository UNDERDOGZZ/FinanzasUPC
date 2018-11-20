package com.finanzas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 4, message = "Usuario debe tener como minimo 4 caracteres")
	@Column(name = "nombre_usuario", nullable = false, length = 150)
	private String nombreUsuario;

	@Size(min = 4, message = "Contrasena debe tener como minimo 4 caracteres")
	@Column(name = "contrasena", nullable = false, length = 150)
	private String contrasena;

	@Size(min = 3, message = "Empresa debe tener como minimo 3 caracteres")
	@Column(name = "empresa", nullable = false, length = 150)
	private String empresa;

	@Size(min = 8, message = "RUC debe tener como minimo 11 caracteres")
	@Column(name = "ruc", nullable = false, length = 11)
	private String ruc;
	
	@Column(name = "logeado", nullable = false)
	private boolean logeado;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

	
	
}
