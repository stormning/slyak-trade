/*
 * Project:  slyak-blog
 * Module:   slyak-blog
 * File:     IndexController.java
 * Modifier: nzhou
 * Modified: 2015-03-30 17:21
 * Copyright (c) 2014 Wisorg All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.controller;

import com.slyak.api.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/3/30
 */
@Controller
@RequestMapping
public class HomeCtl {

    @RequestMapping
    public String index(Model model,String userId) {
        User user = new User();
        user.setName("jack");
        model.addAttribute("a","hihi");
        model.addAttribute("user",user);
        return "index";
    }

    public void about(){

    }
}
