package com.slyak.api.user;

import com.slyak.bean.UserBase;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/5/13
 */
@Entity
@Table(name = "t_user")
public class User extends UserBase {

}
