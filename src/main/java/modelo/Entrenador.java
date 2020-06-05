/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_entrenador")
    @NotNull
    private Short cod_entrenador;

    @Column(name = "nombre")
    @Size(max = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido1")
    @Size(max = 80)
    @NotNull
    private String apellido1;

    @Column(name = "apellido2")
    @Size(max = 80)
    @NotNull
    private String apellido2;

    @JoinColumn(name = "depende_de", referencedColumnName = "cod_entrenador")
    @ManyToOne(fetch = FetchType.EAGER)
    private Entrenador depende_de;

    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Equipo id_equipo;

    

    public Entrenador() {

    }

    public Entrenador(Short cod_entrenador) {
        this.cod_entrenador = cod_entrenador;
    }

    /**
     * Obtiene la id del entrenador
     *
     * @return id del entrenador
     */
    public Short getCod_entrenador() {
        return cod_entrenador;
    }

    /**
     * Obtiene el nombre del entrenador
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el primer apellido del entrenador
     *
     * @return primer apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * obtiene el segundo apellido del entrenador
     *
     * @return segundo apellido
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Obtiene la id de otro entrenador si este depende realmente
     *
     * @return id de otro entrenador
     */
    public Entrenador getDepende_de() {
        return depende_de;
    }

    /**
     * Obtiene el id del equipo
     *
     * @return id del equipo
     */
    public Equipo getId_equipo() {
        return id_equipo;
    }


    /**
     * Establece la id del entrenador
     *
     * @param cod_entrenador
     */
    public void setCod_entrenador(Short cod_entrenador) {
        this.cod_entrenador = cod_entrenador;
    }

    /**
     * Establece el nombre del entrenador
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del entrenador
     *
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Establece el segundo apellido del entrenador
     *
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Establece una id de otro entrenador si depende de el
     *
     * @param depende_de
     */
    public void setDepende_de(Entrenador depende_de) {
        this.depende_de = depende_de;
    }

    /**
     * Establece la id del equipo
     *
     * @param id_equipo
     */
    public void setId_equipo(Equipo id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    @Override
    public String toString() {
        return "Entrenador : " + "Id del entrenador:" + cod_entrenador + ", nombre: " + nombre +
                ", primer apellido: " + apellido1 + ", segundo apellido: " + apellido2 + ", id_equipo: " + id_equipo;
    }
    
     @Override
    public boolean equals(Object object) {
         if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.cod_entrenador== null && other.cod_entrenador != null) || (this.cod_entrenador != null && !this.cod_entrenador.equals(other.cod_entrenador))) {
            return false;
        }
        return true;
    }
    
    

}
