/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     IndexController.java
 * Modifier: stormning
 * Modified: 2014-11-18 10:57
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.trade.web;

import com.slyak.trade.module.article.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">ningzhou</a>
 * @version V1.0, 2014/11/17
 */

@Controller
public class IndexController {

    @Autowired
    private ArticleRepo articleRepo;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        //动态
        //简介
        //产品
        //案例
        return "index";
    }

    /**
     * 关于:简介 理念 资质 动态
     */
    @RequestMapping("/about")
    public String about() {
        return "about";
    }


    /**
     * 产品
     */
    @RequestMapping("/product")
    public String product() {
        return "product";
    }

    /**
     * 工程案例
     *
     * @return
     */
    @RequestMapping("/project")
    public String project() {
        return "project";
    }

    /**
     * 服务
     *
     * @return
     */
    @RequestMapping("/service")
    public String service() {
        return "service";
    }


    /**
     * 联系我们
     *
     * @return
     */
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/msg")
    public String message() {
        return "message";
    }
}
