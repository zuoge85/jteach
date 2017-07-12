package org.forkjoin.jteach.open.db.dao;

import org.forkjoin.jdbckit.core.impi.BaseDaoImpi;
import org.forkjoin.jteach.open.db.entity.AccessTokenDO;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AccessTokenDao extends BaseDaoImpi<AccessTokenDO,AccessTokenDO.Key>  {
	public AccessTokenDao() {
		super(AccessTokenDO.ENTITY_META);
	}

	public AccessTokenDO get(int id) {
		return get(new AccessTokenDO.Key(id));
	}
}
