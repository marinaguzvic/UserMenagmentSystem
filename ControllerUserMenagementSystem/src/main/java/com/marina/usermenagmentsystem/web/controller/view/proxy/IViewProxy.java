/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller.view.proxy;

import java.util.List;

/**
 *
 * @author MARINA
 */
public interface IViewProxy {
    public List<String> getHeaders();
    public String getValueForHeader(String header);
    public String getNameForHeader(String header);
    public String getLinkForValue();
}
