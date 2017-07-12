package org.forkjoin.jteach.open.cache;

import org.forkjoin.jteach.core.cache.EntityCache;
import org.forkjoin.jteach.open.db.dao.UserDao;
import org.forkjoin.jteach.open.db.entity.UserDO;
import org.forkjoin.jteach.open.db.entity.meta.UserMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
@Component
public class UserCache extends EntityCache<UserDO.Key, UserDO> {
    @Autowired
    private UserDao userDao;

    public UserCache() {
        super(UserDO.class, UserMeta.instance);
    }

    @PostConstruct
    public void init() {
        super.init(userDao);
    }
}
