package com.curso.demo.model.clases;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.TreeSet;

@Entity
public class CocheWeb {
    @Id
    private int idCoche;
    private String marca;
    private String modelo;
    @Pattern(regexp = "^[0-9]{4}[A-Za-z]{3}$")
    private String matricula;
    @Min(1)
    private int precio;
    private EstadoCoche estadoCoche = EstadoCoche.venta;
    private TipoCoche tipoCoche = TipoCoche.turismo;
    private TreeSet<ReparacionesWeb>listaReparaciones;

    public CocheWeb(int idCoche, String marca, String modelo, String matricula, int precio) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
    }

    public CocheWeb() {
    }

    public EstadoCoche getEstadoCoche() {
        return estadoCoche;
    }

    public CocheWeb setEstadoCoche(EstadoCoche estadoCoche) {
        this.estadoCoche = estadoCoche;
        return this;
    }

    public TipoCoche getTipoCoche() {
        return tipoCoche;
    }

    public CocheWeb setTipoCoche(TipoCoche tipoCoche) {
        this.tipoCoche = tipoCoche;
        return this;
    }

    public TreeSet<ReparacionesWeb> getListaReparaciones() {
        return listaReparaciones;
    }

    public CocheWeb setListaReparaciones(TreeSet<ReparacionesWeb> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
        return this;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public CocheWeb setIdCoche(int idCoche) {
        this.idCoche = idCoche;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public CocheWeb setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public CocheWeb setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getMatricula() {
        return matricula;
    }

    public CocheWeb setMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public int getPrecio() {
        return precio;
    }

    public CocheWeb setPrecio(int precio) {
        this.precio = precio;
        return this;
    }
}
