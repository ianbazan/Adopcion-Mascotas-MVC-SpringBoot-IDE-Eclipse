package edu.cibertec.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class SolicitudAdopcion {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long solicitudAdopcion_id;
	
	@Column(nullable = false, length = 60)
	private String nombre;
	
	@Column(nullable = false, length = 60)
	private String email;
	
	@Column(nullable = false)
	private int telefono;
	
	@Column(nullable = false, length = 60)
	private String direccion;
	
	@Column(nullable = false, length = 60)
	private String comentarios;

	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "mascota_id")
	   private Mascotas mascota;

	public SolicitudAdopcion(Long solicitudAdopcion_id, String nombre, String email, int telefono, String direccion,
			String comentarios, Mascotas mascota) {
		super();
		this.solicitudAdopcion_id = solicitudAdopcion_id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.comentarios = comentarios;
		this.mascota = mascota;
	}

	public SolicitudAdopcion() {
		super();
	}

	public Long getSolicitudAdopcion_id() {
		return solicitudAdopcion_id;
	}

	public void setSolicitudAdopcion_id(Long solicitudAdopcion_id) {
		this.solicitudAdopcion_id = solicitudAdopcion_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Mascotas getMascota() {
		return mascota;
	}

	public void setMascota(Mascotas mascota) {
		this.mascota = mascota;
	}

	

}
