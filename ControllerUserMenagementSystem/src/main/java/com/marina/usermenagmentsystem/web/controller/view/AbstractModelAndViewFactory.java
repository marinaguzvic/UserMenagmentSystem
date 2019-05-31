/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller.view;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MARINA
 */
public abstract class AbstractModelAndViewFactory {
    
    public ModelAndView templateExecute(String name){
        ModelAndView view = new ModelAndView(name);
        setLinks(view);
        return view;
    }

    private void setLinks(ModelAndView view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
