package com.curso.demo.model.clases;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class ClienteWeb {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSequence")
    @SequenceGenerator(name = "idSequence", sequenceName = "id_cliente",
            initialValue = 1, allocationSize = 50)
    @NotNull (message = "El campo id es obligatorio")
    private int id;
    @NotNull (message = "Este campo no puede estar vacío")
    @Size (min = 3, message = "El nombre no puede tener menos de 3 letras")
    private String nombre;
    @NotNull (message = "La direccion no puede ser estar vacia")
    @Size (min = 3, message = "La direccion no puede tener menos de 3 letras")
    private String direccion;
    @Pattern(regexp="^[0-9]{8}(?i)[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$", message = "El dni tiene " +
            "8 numeros y una letra")
    private String dni;
    @NotNull (message = "Este campo no puede estar vacio")
    @Pattern(regexp="^[6|7][0-9]{8}$", message = "El telefono debe empezar por 6 o 9 y tener 9 digitos")
    private String telefono;

    public ClienteWeb(String nombre, String direccion, String dni, String telefono) {
        this.id = 1;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int crearId(String dni) {
        id = Integer.parseInt(dni.substring(0,7));
        return id;
    }

    public ClienteWeb() {
    }

    public int getId() {
        return id;
    }

    public ClienteWeb setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ClienteWeb setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public ClienteWeb setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public ClienteWeb setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public ClienteWeb setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

}

