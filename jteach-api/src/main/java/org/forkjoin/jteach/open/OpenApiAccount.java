package org.forkjoin.jteach.open;

import org.forkjoin.jteach.open.db.entity.UserDO;

import java.util.Date;

/**
 * @author zuoge85@gmail.com on 2017/5/16.
 */
public class OpenApiAccount {
    private UserDO userDO;

    public OpenApiAccount(UserDO userDO) {
        this.userDO = userDO;
    }

    public int getId() {
        return userDO.getId();
    }

    public String getName() {
        return userDO.getName();
    }

    public String getNickName() {
        return userDO.getNickName();
    }

    public String getMobile() {
        return userDO.getMobile();
    }

    public String getUuid() {
        return userDO.getUuid();
    }

    public String getPassword() {
        return userDO.getPassword();
    }

    public Date getCreateTime() {
        return userDO.getCreateTime();
    }

    public Date getUpdateTime() {
        return userDO.getUpdateTime();
    }
}
