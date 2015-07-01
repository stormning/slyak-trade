package com.slyak.api.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/25
 */
public interface FeedService {
    Page<Feed> listAll(Pageable pageable);
    Feed save(Feed feed);
}
