/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     ArticleRepo.java
 * Modifier: stormning
 * Modified: 2014-11-20 16:38
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.trade.module.article.repo;

import com.slyak.framework.bean.ContentRepo;
import com.slyak.trade.module.article.Article;
import com.slyak.trade.module.article.ArticleType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2014/11/20
 */
public interface ArticleRepo extends ContentRepo<Article> {

    @Query("from Article where type in ?1 and status=0 order by id desc")
    Slice<Article> findByTypeIn(Set<ArticleType> articleTypes, Pageable pageable);
}
