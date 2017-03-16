package co.unicauca.proyectobase.controladores.usuarios;

import co.unicauca.proyectobase.entidades.Usuario;
import co.unicauca.proyectobase.controladores.usuarios.util.JsfUtil;
import co.unicauca.proyectobase.controladores.usuarios.util.JsfUtil.PersistAction;
import co.unicauca.proyectobase.usuarios.beans.UsuarioFacade;
import co.unicauca.proyectobase.utilidades.Utilidades;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private co.unicauca.proyectobase.usuarios.beans.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;

    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public String prepareCreate() {
        selected = new Usuario();
        return "Create";
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
            Utilidades.redireccionar("List.xhtml");
        }
    }
    public void cancel() {
        Utilidades.redireccionar("List.xhtml");
    }

    public void prepareUpdate(Usuario usu) {
        selected = usu;
        Utilidades.redireccionar("Edit.xhtml");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
        Utilidades.redireccionar("List.xhtml");
    }

    public void destroy(Usuario usu) {
        selected = usu;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        Utilidades.redireccionar("List.xhtml");
    }

    public void prepareView(Usuario usu) {
        selected = usu;
        Utilidades.redireccionar("View.xhtml");
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);

            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

}
