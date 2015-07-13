package com.slyak.api.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.slyak.bean.BizFetcher;
import com.slyak.bean.BizKey;
import com.slyak.bean.Bizable;
import com.slyak.bean.Status;
import com.slyak.core.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/25
 */
@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedRepo feedRepo;

    @Autowired
    private BizFetcher<Bizable> bizFetcher;

    private Map<Class, FeedTemplateRender<Bizable>> feedTemplateRendersMap = Maps.newHashMap();

    public void setFeedTemplateRenders(List<FeedTemplateRender<Bizable>> feedTemplateRenders) {
        for (FeedTemplateRender<Bizable> ftr : feedTemplateRenders) {
            Class parameter0 = ClassUtils.getGenericParameter0(ftr.getClass());
            feedTemplateRendersMap.put(parameter0, ftr);
        }
    }

    @Override
    public Page<Feed> listAll(Pageable pageable) {

        Page<Feed> feedPage = feedRepo.findByStatus(Status.ENABLED, pageable);

        if (feedPage.hasContent()) {

            Map<BizKey, Feed> feeds = Maps.newHashMap();
            for (Feed feed : feedPage) {
                feeds.put(feed.getBizKey(), feed);
            }

            Map<BizKey, Bizable> bizs = bizFetcher.mget(feeds.keySet());
            //biz objects
            Map<Class<? extends Bizable>, List<Bizable>> bizObjects = Maps.newHashMap();
            for (Bizable bizable : bizs.values()) {
                List<Bizable> bos = bizObjects.get(bizable.getBiz());
                if (bos == null) {
                    bos = Lists.newArrayList();
                    bizObjects.put(bizable.getClass(), bos);
                }
                bos.add(bizable);
            }

            for (Map.Entry<Class<? extends Bizable>, List<Bizable>> boe : bizObjects.entrySet()) {
                FeedTemplateRender<Bizable> ftr = feedTemplateRendersMap.get(boe.getKey());
                Map<Long, String> rendered = ftr.mrender(boe.getValue());
                for (Map.Entry<Long, String> re : rendered.entrySet()) {
                    Long id = re.getKey();
                    Bizable first = boe.getValue().get(0);
                    feeds.get(new BizKey(first.getBiz(), id)).setRendered(rendered.get(id));
                }
            }
        }
        return feedPage;
    }

    @Override
    public Feed save(Feed feed) {
        return feedRepo.save(feed);
    }

}
