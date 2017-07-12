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

import org.forkjoin.jteach.open.db.entity.AccessTokenDO;

public final class AccessTokenMeta extends EntityMeta<AccessTokenDO ,AccessTokenDO.Key>{
    public static final Table DB_TABLE_NAME = Table.of("access_token");
    private Map<Key, UniqueInfo> uniqueMap;

    public static final Field ID = Field.of("id");
    public static final Field USER_ID = Field.of("user_id");
    public static final Field TOKEN = Field.of("token");
    public static final Field CREATE_TIME = Field.of("create_time");

    public static final Key UNIQUE_PRIMARY = Key.of("PRIMARY", true);
    public static final Key UNIQUE_TOKEN = Key.of("token", true);

    public static final AccessTokenMeta instance = new AccessTokenMeta();

    private AccessTokenMeta(){
        uniqueMap = new HashMap<>();
        uniqueMap.put(UNIQUE_TOKEN, new UniqueInfo(UNIQUE_TOKEN, TOKEN));
        super.initProperty(ID, "id", int.class, new TypeReference<Integer>() {});
        super.initProperty(USER_ID, "userId", long.class, new TypeReference<Long>() {});
        super.initProperty(TOKEN, "token", String.class, new TypeReference<String>() {});
        super.initProperty(CREATE_TIME, "createTime", java.util.Date.class, new TypeReference<java.util.Date>() {});
    }

    @Override public String getKeyUpdatePartialPrefixSql(){
        return "UPDATE `access_token` SET ";
    }

    @Override public String getKeyWhereByKeySql(){
        return " WHERE `id`=?";
    }

    @Override public String getKeyDeleteSql(){
        return "DELETE FROM `access_token` WHERE `id`=?";
    }

    @Override public Map<Key, UniqueInfo> getUniques(){
            return uniqueMap;
    }

    @Override
    public UniqueInfo getUniques(Key uniqueName){
        return uniqueMap.get(uniqueName);
    }

    @Override
    public int setPreparedStatement(AccessTokenDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
        Object idPtr;
        idPtr = t.getId();

        Object userIdPtr;
        userIdPtr = t.getUserId();

        ps.setObject(i++, userIdPtr);
        Object tokenPtr;
        tokenPtr = t.getToken();

        if(isSetUnique){
            ps.setObject(i++, tokenPtr);
        }
        Object createTimePtr;
        createTimePtr = t.getCreateTime();

        ps.setObject(i++, createTimePtr);
        return i;
    }

    @Override
    public int setAllPreparedStatement(AccessTokenDO t, PreparedStatement ps, int i) throws SQLException {
        Object idPtr;
        idPtr = t.getId();

        ps.setObject(i++,  idPtr);
        Object userIdPtr;
        userIdPtr = t.getUserId();

        ps.setObject(i++,  userIdPtr);
        Object tokenPtr;
        tokenPtr = t.getToken();

        ps.setObject(i++,  tokenPtr);
        Object createTimePtr;
        createTimePtr = t.getCreateTime();

        ps.setObject(i++,  createTimePtr);
        return i;
    }

    @Override
    public int setPreparedStatementKeys(AccessTokenDO t, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, t.getId());
        return i;
    }

    @Override
    public int setKeyPreparedStatement(AccessTokenDO.Key k, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, k.getId());
        return i;
    }

    @Override public String getInsertSql(){
        return "INSERT INTO `access_token` (`user_id`,`token`,`create_time`) VALUES (?,?,?)";
    }

    @Override public String getReplaceSql(){
        return "REPLACE INTO `access_token` (`id`,`user_id`,`token`,`create_time`) VALUES (?,?,?,?)";
    }

    @Override public String getFastInsertPrefixSql(){
        return "INSERT INTO `access_token` (`user_id`,`token`,`create_time`) VALUES ";
    }
    @Override public String getFastInsertValueItemsSql(){
        return " (?,?,?) ";
    }
    @Override public String getUpdateSql(){
        return "UPDATE `access_token` SET `user_id`=?,`token`=?,`create_time`=? WHERE `id`=?";
    }

    @Override public String getSelectByKeySql(){
        return "SELECT * FROM `access_token` WHERE `id`=? ORDER BY `id` DESC";
    }
    @Override public String getSelectCountSql(){
        return "SELECT count(*) FROM `access_token`";
    }
    @Override public String getFormatSelectSql(){
        return "SELECT %s FROM `access_token` ORDER BY `id` DESC";
    }
    @Override public String getFormatSelectPrefixSql(){
        return "SELECT %s FROM `access_token` ";
    }
    @Override public String getSelectPrefixSql(){
        return "SELECT * FROM `access_token` ";
    }
    @Override public String getOrderByIdDescSql(){
        return " ORDER BY `id` DESC";
    }
    @Override public Table getDbTableName(){
        return DB_TABLE_NAME;
    }

    @Override public RowMapper<AccessTokenDO> getRowMapper(){
        return new RowMapper<AccessTokenDO>() {
            @Override
            public AccessTokenDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccessTokenDO o=new AccessTokenDO();
                o.setId(rs.getInt("id"));
                o.setUserId(rs.getLong("user_id"));
                o.setToken(rs.getString("token"));
                o.setCreateTime(rs.getTimestamp("create_time"));
                return o;
            }
        };
    }

    @Override public <C extends AccessTokenDO> RowMapper<C>  getRowMapper(final Class<C> cls){
        return new RowMapper<C>() {
            @Override
            public C mapRow(ResultSet rs, int rowNum) throws SQLException {
                C o;
                try{
                    o = cls.newInstance();
                    o.setId(rs.getInt("id"));
                    o.setUserId(rs.getLong("user_id"));
                    o.setToken(rs.getString("token"));
                    o.setCreateTime(rs.getTimestamp("create_time"));
                    return o;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new SQLException("必须实现默认构造函数",e);
                }
            }
        };
    }
}