/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyectobase.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sahydo
 */
@Entity
@Table(name = "estudiante")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstId", query = "SELECT e FROM Estudiante e WHERE e.estId = :estId"),
    @NamedQuery(name = "Estudiante.findByEstCodigo", query = "SELECT e FROM Estudiante e WHERE e.estCodigo = :estCodigo"),
    @NamedQuery(name = "Estudiante.findByEstNombre", query = "SELECT e FROM Estudiante e WHERE e.estNombre = :estNombre"),
    @NamedQuery(name = "Estudiante.findByEstApellidos", query = "SELECT e FROM Estudiante e WHERE e.estApellidos = :estApellidos"),
    @NamedQuery(name = "Estudiante.findByEstCorreo", query = "SELECT e FROM Estudiante e WHERE e.estCorreo = :estCorreo"),
    @NamedQuery(name = "Estudiante.findByEstCohorte", query = "SELECT e FROM Estudiante e WHERE e.estCohorte = :estCohorte"),
    @NamedQuery(name = "Estudiante.findByEstContrasena", query = "SELECT e FROM Estudiante e WHERE e.estContrasena = :estContrasena"),
    @NamedQuery(name = "Estudiante.findByEstTutor", query = "SELECT e FROM Estudiante e WHERE e.estTutor = :estTutor")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "est_codigo")
    private String estCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_nombre")
    private String estNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_apellidos")
    private String estApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "est_correo")
    private String estCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "est_cohorte")
    private String estCohorte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "est_contrasena")
    private String estContrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_tutor")
    private String estTutor;

    public Estudiante() {
    }

    public Estudiante(Integer estId) {
        this.estId = estId;
    }

    public Estudiante(Integer estId, String estCodigo, String estNombre,String estApellidos, String estCorreo, String estCohorte, String estContrasena, String estTutor) {
        this.estId = estId;
        this.estCodigo = estCodigo;
        this.estNombre = estNombre;
        this.estCorreo = estCorreo;
        this.estCohorte = estCohorte;
        this.estContrasena = estContrasena;
        this.estTutor = estTutor;
        this.estApellidos = estApellidos;
    }

    public String getEstApellidos() {
        return estApellidos;
    }

    public void setEstApellidos(String estApellidos) {
        this.estApellidos = estApellidos;
    }
    
    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(String estCodigo) {
        this.estCodigo = estCodigo;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstCorreo() {
        return estCorreo;
    }

    public void setEstCorreo(String estCorreo) {
        this.estCorreo = estCorreo;
    }

    public String getEstCohorte() {
        return estCohorte;
    }

    public void setEstCohorte(String estCohorte) {
        this.estCohorte = estCohorte;
    }

    public String getEstContrasena() {
        return estContrasena;
    }

    public void setEstContrasena(String estContrasena) {
        this.estContrasena = estContrasena;
    }

    public String getEstTutor() {
        return estTutor;
    }

    public void setEstTutor(String estTutor) {
        this.estTutor = estTutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unicauca.proyectobase.entidades.Estudiante[ estId=" + estId + " ]";
    }
    
}
