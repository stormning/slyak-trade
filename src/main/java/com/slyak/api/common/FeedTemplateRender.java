package com.slyak.api.common;

import com.slyak.bean.Bizable;

import java.util.List;
import java.util.Map;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/30
 */
public interface FeedTemplateRender<T extends Bizable> {

    Map<Long, String> mrender(List<T> value);
}
