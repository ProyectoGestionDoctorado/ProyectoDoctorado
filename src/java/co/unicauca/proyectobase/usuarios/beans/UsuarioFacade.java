/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyectobase.usuarios.beans;

import co.unicauca.proyectobase.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author libardo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "ProyectoIIBasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public boolean buscarPorEmail(String usuemail) {
        Query query = getEntityManager().createNamedQuery("Usuario.findByUsuemail");
        query.setParameter("usuemail", usuemail);
        List<Usuario> resultList = query.getResultList();
        return !resultList.isEmpty();

    }    
    
}
