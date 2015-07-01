package com.slyak.api.common;

import com.slyak.bean.BizKey;
import com.slyak.bean.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/25
 */
@Repository
public interface FeedRepo extends JpaRepository<Feed, BizKey> {
    Page<Feed> findByStatus(Status status, Pageable pageable);
}
