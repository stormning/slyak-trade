package com.slyak.util;

import java.io.Serializable;
import java.util.List;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/19
 */
public class Menu implements Serializable {
    private String title;
    private String url;
    private boolean active;
    private List<Menu> subMenus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", active=" + active +
                ", subMenus=" + subMenus +
                '}';
    }
}
