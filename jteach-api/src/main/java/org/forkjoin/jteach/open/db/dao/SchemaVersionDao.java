package org.forkjoin.jteach.open.db.dao;

import org.forkjoin.jdbckit.core.impi.BaseDaoImpi;
import org.forkjoin.jteach.open.db.entity.SchemaVersionDO;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SchemaVersionDao extends BaseDaoImpi<SchemaVersionDO,SchemaVersionDO.Key>  {
	public SchemaVersionDao() {
		super(SchemaVersionDO.ENTITY_META);
	}

	public SchemaVersionDO get(String version) {
		return get(new SchemaVersionDO.Key(version));
	}
}
