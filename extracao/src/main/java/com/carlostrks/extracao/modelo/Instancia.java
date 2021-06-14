/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jcarlos
 */
public class Instancia {
    
    private List<Role> roles;
    
    public Instancia(){
        this.roles = new ArrayList<>();
    }
    
    public Instancia(List<Role> roles){
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public void addRole(Role role){
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "InstanciaDePadrao{" + "roles=" + roles + '}';
    }
    
    
    
}
