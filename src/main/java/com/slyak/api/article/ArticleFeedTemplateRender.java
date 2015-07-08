package com.slyak.api.article;

import com.slyak.api.common.FreemarkerFeedRender;

import java.util.List;
import java.util.Map;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/7/2
 */
public class ArticleFeedTemplateRender extends FreemarkerFeedRender<Article> {

    @Override
    public Map<Long, String> mrender(List<Article> value) {
        return null;
    }
}
