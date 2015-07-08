package com.slyak.api.common;

import com.slyak.bean.Bizable;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/7/7
 */
public abstract class FreemarkerFeedRender<T extends Bizable> implements FeedTemplateRender<T> {

    @Override
    public String render(T bizObj) {
//        FmUtils.renderTpl()
        return null;
    }
}
