package com.beans;

import com.clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author julen
 */
@ManagedBean
@RequestScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    private static List<Persona> lstPersonas = new ArrayList();
    
    public PersonaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        PersonaBean.lstPersonas = lstPersonas;
    }
    
    public void registrar(){
        PersonaBean.lstPersonas.add(this.persona);
    }
    
    public void eliminarPersona(Persona per){
        PersonaBean.lstPersonas.remove(per);
    }
    
    public void validar(FacesContext context,
            UIComponent toValidate, Object value){
        System.out.print("ENTRA EN VALIDAR");
        // FacesContext - Contexto de JSF, acceso a todas las variable manejadas por este framework 
        // UICOmponent - Componente que está invocando el método
        // Object - Valor que trae consigo el componente
        context = FacesContext.getCurrentInstance();
        String texto = (String)value;
        
        if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Sexo NO VÁLIDO"));
        }        
    }
    
}
