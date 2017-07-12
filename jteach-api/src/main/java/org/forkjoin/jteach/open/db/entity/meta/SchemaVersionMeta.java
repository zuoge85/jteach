package  org.forkjoin.jteach.open.db.entity.meta;

import java.beans.Transient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.forkjoin.jdbckit.core.UniqueInfo;


import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import org.forkjoin.jdbckit.core.EntityObject;
import org.forkjoin.jdbckit.core.KeyObject;
import org.forkjoin.jdbckit.core.EntityMeta;
import org.forkjoin.jdbckit.core.identifier.*;

import org.forkjoin.jteach.open.db.entity.SchemaVersionDO;

public final class SchemaVersionMeta extends EntityMeta<SchemaVersionDO ,SchemaVersionDO.Key>{
    public static final Table DB_TABLE_NAME = Table.of("schema_version");
    private Map<Key, UniqueInfo> uniqueMap;

    public static final Field VERSION_RANK = Field.of("version_rank");
    public static final Field INSTALLED_RANK = Field.of("installed_rank");
    public static final Field VERSION = Field.of("version");
    public static final Field DESCRIPTION = Field.of("description");
    public static final Field TYPE = Field.of("type");
    public static final Field SCRIPT = Field.of("script");
    public static final Field CHECKSUM = Field.of("checksum");
    public static final Field INSTALLED_BY = Field.of("installed_by");
    public static final Field INSTALLED_ON = Field.of("installed_on");
    public static final Field EXECUTION_TIME = Field.of("execution_time");
    public static final Field SUCCESS = Field.of("success");

    public static final Key UNIQUE_PRIMARY = Key.of("PRIMARY", true);

    public static final SchemaVersionMeta instance = new SchemaVersionMeta();

    private SchemaVersionMeta(){
        uniqueMap = new HashMap<>();
        super.initProperty(VERSION_RANK, "versionRank", int.class, new TypeReference<Integer>() {});
        super.initProperty(INSTALLED_RANK, "installedRank", int.class, new TypeReference<Integer>() {});
        super.initProperty(VERSION, "version", String.class, new TypeReference<String>() {});
        super.initProperty(DESCRIPTION, "description", String.class, new TypeReference<String>() {});
        super.initProperty(TYPE, "type", String.class, new TypeReference<String>() {});
        super.initProperty(SCRIPT, "script", String.class, new TypeReference<String>() {});
        super.initProperty(CHECKSUM, "checksum", Integer.class, new TypeReference<Integer>() {});
        super.initProperty(INSTALLED_BY, "installedBy", String.class, new TypeReference<String>() {});
        super.initProperty(INSTALLED_ON, "installedOn", java.util.Date.class, new TypeReference<java.util.Date>() {});
        super.initProperty(EXECUTION_TIME, "executionTime", int.class, new TypeReference<Integer>() {});
        super.initProperty(SUCCESS, "success", boolean.class, new TypeReference<Boolean>() {});
    }

    @Override public String getKeyUpdatePartialPrefixSql(){
        return "UPDATE `schema_version` SET ";
    }

    @Override public String getKeyWhereByKeySql(){
        return " WHERE `version`=?";
    }

    @Override public String getKeyDeleteSql(){
        return "DELETE FROM `schema_version` WHERE `version`=?";
    }

    @Override public Map<Key, UniqueInfo> getUniques(){
            return uniqueMap;
    }

    @Override
    public UniqueInfo getUniques(Key uniqueName){
        return uniqueMap.get(uniqueName);
    }

    @Override
    public int setPreparedStatement(SchemaVersionDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
        Object versionRankPtr;
        versionRankPtr = t.getVersionRank();

        ps.setObject(i++, versionRankPtr);
        Object installedRankPtr;
        installedRankPtr = t.getInstalledRank();

        ps.setObject(i++, installedRankPtr);
        Object versionPtr;
        versionPtr = t.getVersion();

        if(isSetUnique){
            ps.setObject(i++, versionPtr);
        }
        Object descriptionPtr;
        descriptionPtr = t.getDescription();

        ps.setObject(i++, descriptionPtr);
        Object typePtr;
        typePtr = t.getType();

        ps.setObject(i++, typePtr);
        Object scriptPtr;
        scriptPtr = t.getScript();

        ps.setObject(i++, scriptPtr);
        Object checksumPtr;
        checksumPtr = t.getChecksum();

        ps.setObject(i++, checksumPtr);
        Object installedByPtr;
        installedByPtr = t.getInstalledBy();

        ps.setObject(i++, installedByPtr);
        Object installedOnPtr;
        installedOnPtr = t.getInstalledOn();

        ps.setObject(i++, installedOnPtr);
        Object executionTimePtr;
        executionTimePtr = t.getExecutionTime();

        ps.setObject(i++, executionTimePtr);
        Object successPtr;
        successPtr = t.getSuccess();

        ps.setObject(i++, successPtr);
        return i;
    }

    @Override
    public int setAllPreparedStatement(SchemaVersionDO t, PreparedStatement ps, int i) throws SQLException {
        Object versionRankPtr;
        versionRankPtr = t.getVersionRank();

        ps.setObject(i++,  versionRankPtr);
        Object installedRankPtr;
        installedRankPtr = t.getInstalledRank();

        ps.setObject(i++,  installedRankPtr);
        Object versionPtr;
        versionPtr = t.getVersion();

        ps.setObject(i++,  versionPtr);
        Object descriptionPtr;
        descriptionPtr = t.getDescription();

        ps.setObject(i++,  descriptionPtr);
        Object typePtr;
        typePtr = t.getType();

        ps.setObject(i++,  typePtr);
        Object scriptPtr;
        scriptPtr = t.getScript();

        ps.setObject(i++,  scriptPtr);
        Object checksumPtr;
        checksumPtr = t.getChecksum();

        ps.setObject(i++,  checksumPtr);
        Object installedByPtr;
        installedByPtr = t.getInstalledBy();

        ps.setObject(i++,  installedByPtr);
        Object installedOnPtr;
        installedOnPtr = t.getInstalledOn();

        ps.setObject(i++,  installedOnPtr);
        Object executionTimePtr;
        executionTimePtr = t.getExecutionTime();

        ps.setObject(i++,  executionTimePtr);
        Object successPtr;
        successPtr = t.getSuccess();

        ps.setObject(i++,  successPtr);
        return i;
    }

    @Override
    public int setPreparedStatementKeys(SchemaVersionDO t, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, t.getVersion());
        return i;
    }

    @Override
    public int setKeyPreparedStatement(SchemaVersionDO.Key k, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, k.getVersion());
        return i;
    }

    @Override public String getInsertSql(){
        return "INSERT INTO `schema_version` (`version_rank`,`installed_rank`,`version`,`description`,`type`,`script`,`checksum`,`installed_by`,`installed_on`,`execution_time`,`success`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override public String getReplaceSql(){
        return "REPLACE INTO `schema_version` (`version_rank`,`installed_rank`,`version`,`description`,`type`,`script`,`checksum`,`installed_by`,`installed_on`,`execution_time`,`success`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override public String getFastInsertPrefixSql(){
        return "INSERT INTO `schema_version` (`version_rank`,`installed_rank`,`version`,`description`,`type`,`script`,`checksum`,`installed_by`,`installed_on`,`execution_time`,`success`) VALUES ";
    }
    @Override public String getFastInsertValueItemsSql(){
        return " (?,?,?,?,?,?,?,?,?,?,?) ";
    }
    @Override public String getUpdateSql(){
        return "UPDATE `schema_version` SET `version_rank`=?,`installed_rank`=?,`version`=?,`description`=?,`type`=?,`script`=?,`checksum`=?,`installed_by`=?,`installed_on`=?,`execution_time`=?,`success`=? WHERE `version`=?";
    }

    @Override public String getSelectByKeySql(){
        return "SELECT * FROM `schema_version` WHERE `version`=? ORDER BY `version` DESC";
    }
    @Override public String getSelectCountSql(){
        return "SELECT count(*) FROM `schema_version`";
    }
    @Override public String getFormatSelectSql(){
        return "SELECT %s FROM `schema_version` ORDER BY `version` DESC";
    }
    @Override public String getFormatSelectPrefixSql(){
        return "SELECT %s FROM `schema_version` ";
    }
    @Override public String getSelectPrefixSql(){
        return "SELECT * FROM `schema_version` ";
    }
    @Override public String getOrderByIdDescSql(){
        return " ORDER BY `version` DESC";
    }
    @Override public Table getDbTableName(){
        return DB_TABLE_NAME;
    }

    @Override public RowMapper<SchemaVersionDO> getRowMapper(){
        return new RowMapper<SchemaVersionDO>() {
            @Override
            public SchemaVersionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                SchemaVersionDO o=new SchemaVersionDO();
                o.setVersionRank(rs.getInt("version_rank"));
                o.setInstalledRank(rs.getInt("installed_rank"));
                o.setVersion(rs.getString("version"));
                o.setDescription(rs.getString("description"));
                o.setType(rs.getString("type"));
                o.setScript(rs.getString("script"));
                o.setChecksum(rs.getInt("checksum"));
                o.setInstalledBy(rs.getString("installed_by"));
                o.setInstalledOn(rs.getTimestamp("installed_on"));
                o.setExecutionTime(rs.getInt("execution_time"));
                o.setSuccess(rs.getBoolean("success"));
                return o;
            }
        };
    }

    @Override public <C extends SchemaVersionDO> RowMapper<C>  getRowMapper(final Class<C> cls){
        return new RowMapper<C>() {
            @Override
            public C mapRow(ResultSet rs, int rowNum) throws SQLException {
                C o;
                try{
                    o = cls.newInstance();
                    o.setVersionRank(rs.getInt("version_rank"));
                    o.setInstalledRank(rs.getInt("installed_rank"));
                    o.setVersion(rs.getString("version"));
                    o.setDescription(rs.getString("description"));
                    o.setType(rs.getString("type"));
                    o.setScript(rs.getString("script"));
                    o.setChecksum(rs.getInt("checksum"));
                    o.setInstalledBy(rs.getString("installed_by"));
                    o.setInstalledOn(rs.getTimestamp("installed_on"));
                    o.setExecutionTime(rs.getInt("execution_time"));
                    o.setSuccess(rs.getBoolean("success"));
                    return o;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new SQLException("必须实现默认构造函数",e);
                }
            }
        };
    }
}