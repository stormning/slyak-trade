/*
 * Project:  slyak-trade
 * Module:   slyak-trade
 * File:     Article.java
 * Modifier: stormning
 * Modified: 2014-11-20 09:38
 * Copyright (c) 2014 Slyak All Rights Reserved.
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent
 * or the registration of a utility model, design or code.
 */

package com.slyak.trade.model;

import com.slyak.common.Content;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2014/11/20
 */
@Entity
@Table(name = "t_article")
public class Article extends Content {

}
