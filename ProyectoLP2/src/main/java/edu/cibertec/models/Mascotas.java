package edu.cibertec.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascotas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long mascota_id;
    
    @Column(nullable = false, length = 60)
    private String nombre;
    
    @Column(nullable = false, length = 60)
    private String especie;
    
    @Column(nullable = false, length = 60)
    private String raza;
    
    @Column(nullable = false, length = 60)
    private String descripcion;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date fecha_registro;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refugio_id")
    private Refugios refugio;

    public Mascotas(Long mascota_id, String nombre, String especie, String raza, String descripcion, Date fecha_registro, Refugios refugio) {
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.refugio = refugio;
    }

    public Mascotas() {}

    // Getters and Setters
    public Long getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(Long mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Refugios getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugios refugio) {
        this.refugio = refugio;
    }
}
