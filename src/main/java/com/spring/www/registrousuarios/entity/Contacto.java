package com.spring.www.registrousuarios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el campo de nombre no puede quedar vacio")
    private String nombre;

    @NotBlank(message = "el apellido paterno de nombre no puede quedar vacio")
    private String app;

    @NotBlank(message = "el apellido materno de nombre no puede quedar vacio")
    private String apm;

    @NotBlank(message = "el campo de número de contacto no puede quedar vacio")
    @Pattern(regexp = "\\d{10}", message = "el número de contacto debe tener 8 dígitos")
    private String numero;

    @NotBlank(message = "el campo de correo electronico no puede quedar vacio")
    @Email(message = "correo electrónico no es válido")
    private String correo;

    @NotBlank(message = "el campo de alcaldia no puede quedar vacio")
    private String alcaldia;

    @NotBlank(message = "el campo de codigo postal no puede quedar vacio")
    @Pattern(regexp = "\\d{6}", message = "el número de codigo postal debe tener 6 dígitos")
    private String cp;

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

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) {
        this.alcaldia = alcaldia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}
