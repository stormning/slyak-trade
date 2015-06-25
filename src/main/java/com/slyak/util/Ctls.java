package com.slyak.util;

import com.slyak.core.spring.web.AppContext;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/25
 */
public class Ctls {

    public static void menu(String name) {
        AppContext.getRequest().setAttribute(Constants.ATTR_MENU_NAME, name);
    }
}
