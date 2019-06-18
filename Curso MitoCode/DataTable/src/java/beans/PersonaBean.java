package beans;

import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
        this.lstPersonas = lstPersonas;
    }
    
    public void agregarPersona(){
        PersonaBean.lstPersonas.add(this.persona);
    }
    
    public void eliminarPersona(Persona per){
        PersonaBean.lstPersonas.remove(per);
    }
    
}
