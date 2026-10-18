package com.clientes.clientes.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;

    @NotBlank(message = "El nombre es obligatorio")
    @Field("nombre")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Field("apellidos")
    private String apellidos;

    @Field("category")
    private String category;
    @Field("limite_credito")
    private float limite_credito;

    @Field("fecha_creacion")
    private LocalDateTime creationDate;

    public Cliente() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getLimite_credito() { return limite_credito; }
    public void setLimite_credito(float limite_credito) { this.limite_credito = limite_credito; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
}