package com.slyak.api.user;

import com.slyak.bean.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/5/13
 */
public class UserDetail extends User {

    public String getDisplayName(){
        return getName()+" is my friend";
    }
}
