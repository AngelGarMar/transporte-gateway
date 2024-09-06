package com.transporte.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "cat_usuarios")
@Data
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "apaterno")
    private String apaterno;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "amaterno")
    private String amaterno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado")
    private Date creado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado")
    private Date actualizado;

    @NotBlank
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(min = 1, max = 60)
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "estatus")
    private int status;

    @ManyToMany
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "usuarios_id"),
        inverseJoinColumns = @JoinColumn(name = "roles_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"usuarios_id", "roles_id"})})
    @JsonIgnoreProperties({"usuarios", "handler", "hibernateLazyInitializer"})
    private List<Role> roles;
}
