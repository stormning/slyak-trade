/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     ArticleServiceImpl.java
 * Modifier: stormning
 * Modified: 2014-12-09 16:07
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.trade.module.article.service.impl;

import com.slyak.trade.module.article.Article;
import com.slyak.trade.module.article.ArticleType;
import com.slyak.trade.module.article.repo.ArticleRepo;
import com.slyak.trade.module.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2014/12/9
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public List<Article> listArticles(Set<ArticleType> articleTypes, int size) {
        Slice<Article> articles = articleRepo.findByTypeIn(articleTypes, new PageRequest(0, size));
        return articles.getContent();
    }
}
