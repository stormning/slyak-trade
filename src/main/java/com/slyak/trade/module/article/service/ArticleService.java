/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     ArticleService.java
 * Modifier: stormning
 * Modified: 2014-12-09 16:05
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.trade.module.article.service;

import com.slyak.trade.module.article.Article;
import com.slyak.trade.module.article.ArticleType;

import java.util.List;
import java.util.Set;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2014/12/9
 */
public interface ArticleService {

    List<Article> listArticles(Set<ArticleType> articleTypes, int limit);

}
