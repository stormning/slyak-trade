package com.slyak.api.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.slyak.bean.Assembler;
import com.slyak.bean.Assemblers;
import com.slyak.bean.Bizable;
import com.slyak.core.freemarker.FmUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ClassUtils;

import java.util.List;
import java.util.Map;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/7/7
 */
public abstract class AbstractFreemarkerFeedRender<T extends Bizable> implements FeedTemplateRender<T>, InitializingBean {

    private List<Assembler> ass = Lists.newArrayList();

    private Assemblers assemblers;

    @Override
    public void afterPropertiesSet() throws Exception {
        initAssemblers(ass);
        assemblers = new Assemblers(ass);
    }

    protected void initAssemblers(List<Assembler> assemblers) {
        //init assemblers
    }

    protected String getTpl() {
        return null;
    }

    @Override
    public Map<Long, String> mrender(List<T> objs) {
        assemblers.assemble(objs);
        String tpl = getTpl() == null ? lookUpTpl(objs.get(0).getClass()) : getTpl();
        Map<Long, String> results = Maps.newHashMap();
        for (T o : objs) {
            results.put(o.getId(), FmUtils.renderTpl(tpl, objs));
        }
        return results;
    }

    private String lookUpTpl(Class<? extends Bizable> aClass) {
        return "/feed/" + ClassUtils.getShortName(aClass);
    }
}
