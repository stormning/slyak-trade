package com.slyak.api.article;

import com.slyak.bean.Content;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/30
 */
@Entity
@Table(name = "t_article")
public class Artice extends Content {

}
