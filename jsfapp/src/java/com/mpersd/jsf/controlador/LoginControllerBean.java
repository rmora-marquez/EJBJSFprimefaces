package com.mpersd.jsf.controlador;

import com.mpersd.jsf.modelo.UsuarioBean;
import com.mpersd.jsf.negocio.LoginServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginControllerBean {
    @EJB
    private LoginServiceLocal loginBo;
    //modelo
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean modelo;
            
    public LoginControllerBean() {
    }
    
    public void login() throws IOException{
        FacesContext fc = FacesContext.getCurrentInstance();
        modelo.setNombre( 
            loginBo.login(modelo.getUsername() ,modelo.getPassword()) );
        if(modelo.getNombre() == null){
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Datos incorrectos"
                    ,"Usuario o password incorrectos");
           fc.addMessage(null, fmsg);
        }else{
            fc.getExternalContext().redirect("tareas.xhtml?redirect=true");
        }
    }

    public UsuarioBean getModelo() {
        return modelo;
    }

    public void setModelo(UsuarioBean modelo) {
        this.modelo = modelo;
    }
    
    
}
