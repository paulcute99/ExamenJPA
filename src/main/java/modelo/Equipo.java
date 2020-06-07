/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "año_fundación")
    @NotNull
    private Year año_fundacion;

    @Column(name = "num_socios")
    @NotNull
    private int num_socios;

    @Column(name = "presidente_nombre")
    @NotNull
    private String presidente_nombre;

    @Column(name = "presidente_apellido1")
    @NotNull
    private String presidente_apellido1;

    @Column(name = "presidente_apellido2")
    @NotNull
    private String presidente_apellido2;

    @Column(name = "estadio")
    private String estadio;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Entrenador> listaEntrenador;

    public Equipo() {

    }

    public Equipo(Short Id) {
        this.id = id;
    }

    /**
     * Obtiene la id del equipo
     *
     * @return id
     */
    public Short getId() {
        return id;
    }

    /**
     * Obtiene el nombre del equipo
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtine el año de la fundacion del equipo
     *
     * @return año_fundacion
     */
    public Year getAño_fundacion() {
        return año_fundacion;
    }

    /**
     * Obtiene el numero de socios del equipo
     *
     * @return numero de socios
     */
    public int getNum_socios() {
        return num_socios;
    }

    /**
     * Obtiene el primer apellido del presidente del equipo
     *
     * @return primer apellido del presidente
     */
    public String getPresidente_apellido1() {
        return presidente_apellido1;
    }

    /**
     * Obtiene el segundo apellido del presidente
     *
     * @return segundo apellido
     */
    public String getPresidente_apellido2() {
        return presidente_apellido2;
    }

    /**
     * Obtiene el estadio en el que esta situado el equipo
     *
     * @return estadio
     */
    public String getEstadio() {
        return estadio;
    }

    public List<Entrenador> getListaEntrenador() {
        return listaEntrenador;
    }
    
    

    /**
     * Obtiene el nombre del presidente
     *
     * @return nombre del presidente
     */
    public String getPresidente_nombre() {
        return presidente_nombre;
    }

    /**
     * Establece la id del equipo
     *
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    public void setListaEntrenador(List<Entrenador> listaEntrenador) {
        this.listaEntrenador = listaEntrenador;
    }
    

    /**
     * Establece el nombre del equipo
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el año en el que se fundo el equipo
     *
     * @param año_fundacion
     */
    public void setAño_fundacion(Year año_fundacion) {
        this.año_fundacion = año_fundacion;
    }

    /**
     * Establece el numero de socios del equipo
     *
     * @param num_socios
     */
    public void setNum_socios(int num_socios) {
        this.num_socios = num_socios;
    }

    /**
     * Establece el primer apellido del presidente
     *
     * @param presidente_apellido1
     */
    public void setPresidente_apellido1(String presidente_apellido1) {
        this.presidente_apellido1 = presidente_apellido1;
    }

    /**
     * Establece el segundo apellido del presidente
     *
     * @param presidente_apellido2
     */
    public void setPresidente_apellido2(String presidente_apellido2) {
        this.presidente_apellido2 = presidente_apellido2;
    }

    /**
     * Establece el estadio del equipo
     *
     * @param estadio
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * Establece el nombre del presidente
     *
     * @param presidente_nombre
     */
    public void setPresidente_nombre(String presidente_nombre) {
        this.presidente_nombre = presidente_nombre;
    }

    @Override
    public String toString() {
        return "Equipo:" + id + "," + nombre + "," + num_socios + "," + presidente_nombre + "," + presidente_apellido1 + "," + presidente_apellido2 + "," + estadio + ","+año_fundacion;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
