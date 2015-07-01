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

import com.slyak.api.common.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private FeedService feedService;

    @RequestMapping
    public String index(Pageable pageable, Model model) {
        model.addAttribute("page", feedService.listAll(pageable));
        return "index";
    }

    public void about() {

    }

    public void hi() {

    }
}
