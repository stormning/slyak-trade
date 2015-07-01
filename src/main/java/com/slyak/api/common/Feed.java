package com.slyak.api.common;

import com.slyak.api.user.User;
import com.slyak.bean.BizKey;
import com.slyak.bean.Status;
import com.slyak.bean.Statusable;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/6/25
 */
@Entity
@Table(name = "t_feed")
@IdClass(BizKey.class)
public class Feed extends BizKey implements Statusable{

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Transient
    private User creator;

    @Transient
    private long createAt;

    @Transient
    private String rendered;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

}
