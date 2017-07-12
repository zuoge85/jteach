package org.forkjoin.jteach.open.db.dao;

import org.forkjoin.jdbckit.core.impi.BaseDaoImpi;
import org.forkjoin.jteach.open.db.entity.UserDO;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao extends BaseDaoImpi<UserDO,UserDO.Key>  {
	public UserDao() {
		super(UserDO.ENTITY_META);
	}

	public UserDO get(int id) {
		return get(new UserDO.Key(id));
	}
}
