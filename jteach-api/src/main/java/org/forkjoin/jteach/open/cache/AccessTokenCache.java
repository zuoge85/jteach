package org.forkjoin.jteach.open.cache;

import org.forkjoin.jteach.core.cache.EntityCache;
import org.forkjoin.jteach.open.db.dao.AccessTokenDao;
import org.forkjoin.jteach.open.db.entity.AccessTokenDO;
import org.forkjoin.jteach.open.db.entity.meta.AccessTokenMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zuoge85@gmail.com on 2017/6/8.
 */
@Component
public class AccessTokenCache extends EntityCache<AccessTokenDO.Key, AccessTokenDO> {
    @Autowired
    private AccessTokenDao accessTokenDao;

    public AccessTokenCache() {
        super(AccessTokenDO.class, AccessTokenMeta.instance);
    }


    @PostConstruct
    public void init() {
        super.init(accessTokenDao);
    }
}
