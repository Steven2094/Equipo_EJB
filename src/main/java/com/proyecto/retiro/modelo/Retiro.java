package com.proyecto.retiro.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Retiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;          // Nombre del que reserva
    private Integer edad;           // Edad
    private String telefono;        // Teléfono
    private String correo;          // Correo electrónico
    private LocalDate fechaIngreso; // Fecha de ingreso
    private LocalDate fechaSalida;  // Fecha de salida
    private Integer acompanantes;   // Número de acompañantes

    // Constructor vacío (obligatorio para JPA)
    public Retiro() {
    }

    // Constructor con parámetros
    public Retiro(String nombre, Integer edad, String telefono, String correo,
                  LocalDate fechaIngreso, LocalDate fechaSalida, Integer acompanantes) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.acompanantes = acompanantes;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getAcompanantes() {
        return acompanantes;
    }

    public void setAcompanantes(Integer acompanantes) {
        this.acompanantes = acompanantes;
    }
}