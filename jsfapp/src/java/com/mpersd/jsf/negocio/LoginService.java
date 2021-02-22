package com.mpersd.jsf.negocio;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Stateless
public class LoginService implements LoginServiceLocal {

    @Override
    public String login(String username, String password) {
        if(username.equals("admin") && password.equals("nimda")){
            return "Administrador";
        }
        return null;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
