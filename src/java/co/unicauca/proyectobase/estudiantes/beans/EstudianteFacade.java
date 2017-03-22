/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyectobase.estudiantes.beans;

import co.unicauca.proyectobase.entidades.Estudiante;
import co.unicauca.proyectobase.entidades.Usuario;
import co.unicauca.proyectobase.estudiantes.beans.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sahydo
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "ProyectoIIBasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
    public boolean buscarPorEmail(String usuemail) {
        Query query = getEntityManager().createNamedQuery("Estudiante.findByEstCorreo");
        query.setParameter("est_correo", usuemail);
        List<Usuario> resultList = query.getResultList();
        return !resultList.isEmpty();

    }   
    
}
