package com.slyak.api.article;

import com.slyak.api.common.AbstractFreemarkerFeedRender;
import com.slyak.api.user.User;
import com.slyak.api.user.UserRepo;
import com.slyak.bean.Assembler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/7/2
 */
public class ArticleFeedTemplateRender extends AbstractFreemarkerFeedRender<Article> {

    @Autowired
    private UserRepo userRepo;

    @Override
    protected void initAssemblers(List<Assembler> assemblers) {
        assemblers.add(new Assembler<Article, Long, User>() {
            @Override
            public Long getKey(Article source) {
                return source.getId();
            }

            @Override
            public User get(Long key) {
                return userRepo.findOne(key);
            }

            @Override
            public Map<Long, User> mget(Collection<Long> keys) {
                return null;
            }

            @Override
            public void assemble(Article source, User target) {

            }
        });
    }
}
