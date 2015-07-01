package com.slyak.api.common;

import com.slyak.bean.BizKey;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/30
 */
public interface FeedTemplateRender<T extends BizKey> {

    String render(T bizObj);
}
