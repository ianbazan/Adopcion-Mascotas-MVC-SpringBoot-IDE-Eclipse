package edu.cibertec.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Refugios {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long refugio_id;
    
    @Column(nullable = false, length = 60)
    private String nombre;
    
    @Column(nullable = false, length = 60)
    private String correo_electronico;
    
    @Column(nullable = false)
    private int telefono;

	public Refugios(Long refugio_id, String nombre, String correo_electronico, int telefono) {
		super();
		this.refugio_id = refugio_id;
		this.nombre = nombre;
		this.correo_electronico = correo_electronico;
		this.telefono = telefono;
	}

	public Refugios() {
		super();
	}

	public Long getRefugio_id() {
		return refugio_id;
	}

	public void setRefugio_id(Long refugio_id) {
		this.refugio_id = refugio_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
}
