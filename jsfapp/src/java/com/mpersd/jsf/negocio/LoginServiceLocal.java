package com.mpersd.jsf.negocio;

import javax.ejb.Local;

@Local
public interface LoginServiceLocal {

    String login(String username, String password);
    
}
