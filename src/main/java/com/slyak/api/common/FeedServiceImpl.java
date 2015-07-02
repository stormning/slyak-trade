package com.slyak.api.common;

import com.google.common.collect.Maps;
import com.slyak.bean.BizFetcher;
import com.slyak.bean.BizKey;
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
    private BizFetcher bizFetcher;

    private Map<Class, FeedTemplateRender> feedTemplateRendersMap = Maps.newHashMap();

    public void setFeedTemplateRenders(List<FeedTemplateRender> feedTemplateRenders) {
        for (FeedTemplateRender ftr : feedTemplateRenders) {
            Class parameter0 = ClassUtils.getGenericParameter0(ftr.getClass());
            feedTemplateRendersMap.put(parameter0, ftr);
        }
    }

    @Override
    public Page<Feed> listAll(Pageable pageable) {
        Page<Feed> feedPage = feedRepo.findByStatus(Status.ENABLED, pageable);

        Map<BizKey, Feed> feeds = Maps.newHashMap();
        for (Feed feed : feedPage) {
            feeds.put(feed.getBizKey(), feed);
        }
        Map<BizKey, ? extends BizKey> bizs = bizFetcher.mget(feeds.keySet());
        for (Map.Entry<BizKey, ? extends BizKey> bke : bizs.entrySet()) {
            BizKey value = bke.getValue();
            feeds.get(bke.getKey()).setRendered(feedTemplateRendersMap.get(value.getClass()).render(value));
        }
        return feedPage;
    }

    @Override
    public Feed save(Feed feed) {
        return feedRepo.save(feed);
    }

}
