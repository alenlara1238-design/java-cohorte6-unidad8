package com.dev.senior.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Venta> ventas = new ArrayList<>();

    public Usuario(){}

    public Usuario(String nombre, String correo, String contraseña, Rol rol){
        this.nombre = nombre;
        this.correo= correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getContraseña(){
        return this.contraseña;
    }

    public void setRol(Rol rol){
        this.rol = rol;
    }

    public Rol getRol(){
        return this.rol;
    }

    public void setVentas(List<Venta> ventas){
        this.ventas = ventas;
    }

    public List<Venta> getVentas(){
        return this.ventas;
    }

}
