package edu.cibertec.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Adopciones {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adopcion_id;
    
	@OneToOne
    @JoinColumn(name = "mascota_id")
    private Mascotas mascota;
    
	@Column(nullable = false, length = 60)
	private String nombre_interesado;
	
	@Column(nullable = false, length = 60)
	private String apellido_interesado;
	
	@Column(nullable = false, length = 60)
	private String correo_electronico_interesado;
	
	@Column(nullable = false)
	private int telefono_interesado;
	
	@Column(nullable = false, length = 60)
	private String direccion_interesado;
	
	@Column(nullable = false)
	private Date fecha_adopcion;

	public Adopciones(Long adopcion_id, Mascotas mascota, String nombre_interesado, String apellido_interesado,
			String correo_electronico_interesado, int telefono_interesado, String direccion_interesado,
			Date fecha_adopcion) {
		super();
		this.adopcion_id = adopcion_id;
		this.mascota = mascota;
		this.nombre_interesado = nombre_interesado;
		this.apellido_interesado = apellido_interesado;
		this.correo_electronico_interesado = correo_electronico_interesado;
		this.telefono_interesado = telefono_interesado;
		this.direccion_interesado = direccion_interesado;
		this.fecha_adopcion = fecha_adopcion;
	}

	public Adopciones() {
		super();
	}

	public Long getAdopcion_id() {
		return adopcion_id;
	}

	public void setAdopcion_id(Long adopcion_id) {
		this.adopcion_id = adopcion_id;
	}

	public Mascotas getMascota() {
		return mascota;
	}

	public void setMascota(Mascotas mascota) {
		this.mascota = mascota;
	}

	public String getNombre_interesado() {
		return nombre_interesado;
	}

	public void setNombre_interesado(String nombre_interesado) {
		this.nombre_interesado = nombre_interesado;
	}

	public String getApellido_interesado() {
		return apellido_interesado;
	}

	public void setApellido_interesado(String apellido_interesado) {
		this.apellido_interesado = apellido_interesado;
	}

	public String getCorreo_electronico_interesado() {
		return correo_electronico_interesado;
	}

	public void setCorreo_electronico_interesado(String correo_electronico_interesado) {
		this.correo_electronico_interesado = correo_electronico_interesado;
	}

	public int getTelefono_interesado() {
		return telefono_interesado;
	}

	public void setTelefono_interesado(int telefono_interesado) {
		this.telefono_interesado = telefono_interesado;
	}

	public String getDireccion_interesado() {
		return direccion_interesado;
	}

	public void setDireccion_interesado(String direccion_interesado) {
		this.direccion_interesado = direccion_interesado;
	}

	public Date getFecha_adopcion() {
		return fecha_adopcion;
	}

	public void setFecha_adopcion(Date fecha_adopcion) {
		this.fecha_adopcion = fecha_adopcion;
	}

	
}
