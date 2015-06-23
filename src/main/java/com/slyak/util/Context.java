package com.slyak.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.slyak.core.freemarker.Ftm;
import com.slyak.core.spring.web.AppContext;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

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

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    private List<Menu> menus = null;

    public List<Menu> getMenus() {
        if (menus == null) {
            Resource resource = resourceLoader.getResource(MENU_FILE);
            try {
                menus = JSON.parseArray(FileUtils.readFileToString(resource.getFile(), "UTF-8"), Menu.class);
            } catch (IOException e) {
                menus = Collections.emptyList();
            }
        }

        if (CollectionUtils.isEmpty(menus)) {
            return menus;
        }

        List<Menu> copy = Lists.newArrayList(menus);
        //set active menu
        loopSetActive(copy, AppContext.getRequestCondition());
        return copy;
    }

    private boolean loopSetActive(List<Menu> menus, RequestCondition<RequestMappingInfo> rc) {
        for (Menu parent : menus) {
            if (AppContext.urlMath(parent.getUrl(), rc)) {
                parent.setActive(true);
                return true;
            } else {
                boolean subActive = loopSetActive(parent.getSubMenus(), rc);
                if (subActive) {
                    parent.setActive(true);
                }
                return subActive;
            }
        }
        return false;
    }

}