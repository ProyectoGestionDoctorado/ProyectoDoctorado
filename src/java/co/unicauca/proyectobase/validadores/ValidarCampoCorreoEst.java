/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyectobase.validadores;

import co.unicauca.proyectobase.estudiantes.beans.EstudianteFacade;
import co.unicauca.proyectobase.usuarios.beans.UsuarioFacade;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Sebastian
 */
@FacesValidator(value="ValidarCampoCorreoEst")
public class ValidarCampoCorreoEst implements Validator{
    
    @EJB
    private EstudianteFacade EstudianteEJB;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        
        String texto = String.valueOf(value);        
        Pattern patron = Pattern.compile("([_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))");
        Matcher encaja = patron.matcher(texto);        
        if(!encaja.find())
        {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Formato de correo inválido. Ej: usuario@gmail.com","Formato de Correo inválido. Ej: usuario@gmail.com");
            throw new ValidatorException(msg);
        }
        else
        {
            if(EstudianteEJB.buscarPorEmail(texto))
            {
                FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Correo electrónico ya se encuentra registrado.","Correo electrónico ya se encuentra registrado.");
                throw new ValidatorException(msg);
            }
        }
        
    }
    
}
