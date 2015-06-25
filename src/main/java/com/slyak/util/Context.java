package com.slyak.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.slyak.core.FileUtils;
import com.slyak.core.freemarker.Ftm;
import com.slyak.core.spring.web.AppContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UrlPathHelper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/19
 */
@Ftm
public class Context {
    private static final String MENU_FILE = "classpath:menu.json";

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private static UrlPathHelper urlPathHelper = new UrlPathHelper();

    private List<Menu> menus = null;

    public List<Menu> getMenus() {
        Resource resource = resourceLoader.getResource(MENU_FILE);
        try {
            File file = resource.getFile();
            if (FileUtils.isModified(file)) {
                menus = JSON.parseArray(FileUtils.readFileToString(file, "UTF-8"), Menu.class);
            }
        } catch (IOException e) {
            menus = Collections.emptyList();
        }
        if (CollectionUtils.isEmpty(menus)) {
            return menus;
        }

        List<Menu> copy = Lists.newArrayList();
        for (Menu menu : menus) {
            copy.add(menu.clone());
        }

        boolean isPath = false;
        String nameOrPath = (String) AppContext.getRequest().getAttribute(Constants.ATTR_MENU_NAME);
        if (StringUtils.isBlank(nameOrPath)) {
            isPath = true;
            nameOrPath = urlPathHelper.getLookupPathForRequest(AppContext.getRequest());
        }
        //set active menu
        loopSetActive(copy, nameOrPath, isPath);
        return copy;
    }

    /**
     * @param menus
     * @param nameOrPath
     * @return
     */
    private boolean loopSetActive(List<Menu> menus, String nameOrPath, boolean isPath) {
        if (!CollectionUtils.isEmpty(menus)) {
            for (Menu parent : menus) {
                String testNameOrPath = isPath ? parent.getUrl() : parent.getName();
                if (StringUtils.equals(testNameOrPath, nameOrPath)) {
                    parent.setActive(true);
                    return true;
                } else {
                    boolean subActive = loopSetActive(parent.getSubMenus(), nameOrPath, isPath);
                    if (subActive) {
                        parent.setActive(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
