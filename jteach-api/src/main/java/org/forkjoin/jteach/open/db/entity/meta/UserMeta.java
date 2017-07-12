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

import org.forkjoin.jteach.open.db.entity.UserDO;

public final class UserMeta extends EntityMeta<UserDO ,UserDO.Key>{
    public static final Table DB_TABLE_NAME = Table.of("user");
    private Map<Key, UniqueInfo> uniqueMap;

    public static final Field ID = Field.of("id");
    public static final Field NAME = Field.of("name");
    public static final Field NICK_NAME = Field.of("nickName");
    public static final Field MOBILE = Field.of("mobile");
    public static final Field UUID = Field.of("uuid");
    public static final Field PASSWORD = Field.of("password");
    public static final Field CREATE_TIME = Field.of("create_time");
    public static final Field UPDATE_TIME = Field.of("update_time");

    public static final Key UNIQUE_MOBILE = Key.of("mobile", true);
    public static final Key UNIQUE_NAME = Key.of("name", true);
    public static final Key UNIQUE_PRIMARY = Key.of("PRIMARY", true);

    public static final UserMeta instance = new UserMeta();

    private UserMeta(){
        uniqueMap = new HashMap<>();
        uniqueMap.put(UNIQUE_MOBILE, new UniqueInfo(UNIQUE_MOBILE, MOBILE));
        uniqueMap.put(UNIQUE_NAME, new UniqueInfo(UNIQUE_NAME, NAME));
        super.initProperty(ID, "id", int.class, new TypeReference<Integer>() {});
        super.initProperty(NAME, "name", String.class, new TypeReference<String>() {});
        super.initProperty(NICK_NAME, "nickName", String.class, new TypeReference<String>() {});
        super.initProperty(MOBILE, "mobile", String.class, new TypeReference<String>() {});
        super.initProperty(UUID, "uuid", String.class, new TypeReference<String>() {});
        super.initProperty(PASSWORD, "password", String.class, new TypeReference<String>() {});
        super.initProperty(CREATE_TIME, "createTime", java.util.Date.class, new TypeReference<java.util.Date>() {});
        super.initProperty(UPDATE_TIME, "updateTime", java.util.Date.class, new TypeReference<java.util.Date>() {});
    }

    @Override public String getKeyUpdatePartialPrefixSql(){
        return "UPDATE `user` SET ";
    }

    @Override public String getKeyWhereByKeySql(){
        return " WHERE `id`=?";
    }

    @Override public String getKeyDeleteSql(){
        return "DELETE FROM `user` WHERE `id`=?";
    }

    @Override public Map<Key, UniqueInfo> getUniques(){
            return uniqueMap;
    }

    @Override
    public UniqueInfo getUniques(Key uniqueName){
        return uniqueMap.get(uniqueName);
    }

    @Override
    public int setPreparedStatement(UserDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
        Object idPtr;
        idPtr = t.getId();

        Object namePtr;
        namePtr = t.getName();

        if(isSetUnique){
            ps.setObject(i++, namePtr);
        }
        Object nickNamePtr;
        nickNamePtr = t.getNickName();

        ps.setObject(i++, nickNamePtr);
        Object mobilePtr;
        mobilePtr = t.getMobile();

        if(isSetUnique){
            ps.setObject(i++, mobilePtr);
        }
        Object uuidPtr;
        uuidPtr = t.getUuid();

        ps.setObject(i++, uuidPtr);
        Object passwordPtr;
        passwordPtr = t.getPassword();

        ps.setObject(i++, passwordPtr);
        Object createTimePtr;
        createTimePtr = t.getCreateTime();

        ps.setObject(i++, createTimePtr);
        Object updateTimePtr;
        updateTimePtr = t.getUpdateTime();

        ps.setObject(i++, updateTimePtr);
        return i;
    }

    @Override
    public int setAllPreparedStatement(UserDO t, PreparedStatement ps, int i) throws SQLException {
        Object idPtr;
        idPtr = t.getId();

        ps.setObject(i++,  idPtr);
        Object namePtr;
        namePtr = t.getName();

        ps.setObject(i++,  namePtr);
        Object nickNamePtr;
        nickNamePtr = t.getNickName();

        ps.setObject(i++,  nickNamePtr);
        Object mobilePtr;
        mobilePtr = t.getMobile();

        ps.setObject(i++,  mobilePtr);
        Object uuidPtr;
        uuidPtr = t.getUuid();

        ps.setObject(i++,  uuidPtr);
        Object passwordPtr;
        passwordPtr = t.getPassword();

        ps.setObject(i++,  passwordPtr);
        Object createTimePtr;
        createTimePtr = t.getCreateTime();

        ps.setObject(i++,  createTimePtr);
        Object updateTimePtr;
        updateTimePtr = t.getUpdateTime();

        ps.setObject(i++,  updateTimePtr);
        return i;
    }

    @Override
    public int setPreparedStatementKeys(UserDO t, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, t.getId());
        return i;
    }

    @Override
    public int setKeyPreparedStatement(UserDO.Key k, PreparedStatement ps, int i) throws SQLException {
        ps.setObject(i++, k.getId());
        return i;
    }

    @Override public String getInsertSql(){
        return "INSERT INTO `user` (`name`,`nickName`,`mobile`,`uuid`,`password`,`create_time`,`update_time`) VALUES (?,?,?,?,?,?,?)";
    }

    @Override public String getReplaceSql(){
        return "REPLACE INTO `user` (`id`,`name`,`nickName`,`mobile`,`uuid`,`password`,`create_time`,`update_time`) VALUES (?,?,?,?,?,?,?,?)";
    }

    @Override public String getFastInsertPrefixSql(){
        return "INSERT INTO `user` (`name`,`nickName`,`mobile`,`uuid`,`password`,`create_time`,`update_time`) VALUES ";
    }
    @Override public String getFastInsertValueItemsSql(){
        return " (?,?,?,?,?,?,?) ";
    }
    @Override public String getUpdateSql(){
        return "UPDATE `user` SET `name`=?,`nickName`=?,`mobile`=?,`uuid`=?,`password`=?,`create_time`=?,`update_time`=? WHERE `id`=?";
    }

    @Override public String getSelectByKeySql(){
        return "SELECT * FROM `user` WHERE `id`=? ORDER BY `id` DESC";
    }
    @Override public String getSelectCountSql(){
        return "SELECT count(*) FROM `user`";
    }
    @Override public String getFormatSelectSql(){
        return "SELECT %s FROM `user` ORDER BY `id` DESC";
    }
    @Override public String getFormatSelectPrefixSql(){
        return "SELECT %s FROM `user` ";
    }
    @Override public String getSelectPrefixSql(){
        return "SELECT * FROM `user` ";
    }
    @Override public String getOrderByIdDescSql(){
        return " ORDER BY `id` DESC";
    }
    @Override public Table getDbTableName(){
        return DB_TABLE_NAME;
    }

    @Override public RowMapper<UserDO> getRowMapper(){
        return new RowMapper<UserDO>() {
            @Override
            public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDO o=new UserDO();
                o.setId(rs.getInt("id"));
                o.setName(rs.getString("name"));
                o.setNickName(rs.getString("nickName"));
                o.setMobile(rs.getString("mobile"));
                o.setUuid(rs.getString("uuid"));
                o.setPassword(rs.getString("password"));
                o.setCreateTime(rs.getTimestamp("create_time"));
                o.setUpdateTime(rs.getTimestamp("update_time"));
                return o;
            }
        };
    }

    @Override public <C extends UserDO> RowMapper<C>  getRowMapper(final Class<C> cls){
        return new RowMapper<C>() {
            @Override
            public C mapRow(ResultSet rs, int rowNum) throws SQLException {
                C o;
                try{
                    o = cls.newInstance();
                    o.setId(rs.getInt("id"));
                    o.setName(rs.getString("name"));
                    o.setNickName(rs.getString("nickName"));
                    o.setMobile(rs.getString("mobile"));
                    o.setUuid(rs.getString("uuid"));
                    o.setPassword(rs.getString("password"));
                    o.setCreateTime(rs.getTimestamp("create_time"));
                    o.setUpdateTime(rs.getTimestamp("update_time"));
                    return o;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new SQLException("必须实现默认构造函数",e);
                }
            }
        };
    }
}