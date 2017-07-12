package  org.forkjoin.jteach.open.db.entity;

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

import org.forkjoin.jteach.open.db.entity.meta.AccessTokenMeta;

public class AccessTokenDO extends EntityObject<AccessTokenDO, AccessTokenDO.Key>{

    private int id;
    /**用户id*/
    private long userId;
    /**登录token*/
    private String token;
    private java.util.Date createTime;

    public static class Key implements KeyObject<AccessTokenDO, AccessTokenDO.Key>{
        private int id;

        public Key() {
        }

        public Key(int id) {
            this.id = id;
        }

        @JsonIgnore
        @Transient
        @Override
        public Object[] getQueryParams() {
            return new Object[]{
                getId()
            };
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toStringKey(){
            return String.valueOf(getId());

        }

        @Override
        public AccessTokenMeta getEntityMeta() {
            return ENTITY_META;
        }

        @Override
        public String toString() {
            return "AccessToken[id:"+ id+ "]";
        }
    }

    @Override
    public Key getKey() {
        return new Key() {

            public int getId() {
                return id;
            }

            @Override
            public String toString() {
                return "AccessToken[id:"+ id+ "]";
            }
        };
    }




    public AccessTokenDO() {
    }

    public AccessTokenDO(long userId,String token,java.util.Date createTime) {
        this.userId = userId;
        this.token = token;
        this.createTime = createTime;
    }


    public AccessTokenDO newInstance(){
        return new AccessTokenDO();
    }

    public void setKey(Object key){
        this.id = ((Number)key).intValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        changeProperty("id",id);
    }

    /**
     * 用户id
     **/
    public long getUserId() {
        return userId;
    }

    /**
     * 用户id
     **/
    public void setUserId(long userId) {
        this.userId = userId;
        changeProperty("userId",userId);
    }

    /**
     * 登录token
     **/
    public String getToken() {
        return token;
    }

    /**
     * 登录token
     **/
    public void setToken(String token) {
        this.token = token;
        changeProperty("token",token);
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
        changeProperty("createTime",createTime);
    }

    @Override
    public Object get(Field dbName){
        switch(dbName.getNativeValue()){
        case "id":
            return id;
        case "user_id":
            return userId;
        case "token":
            return token;
        case "create_time":
            return createTime;
        default :
            return null;
        }
    }


    @Override
    public boolean set(Field dbName, Object obj) {
        switch(dbName.getNativeValue()){
        case "id":
            id = (int)obj;
            return true;
        case "user_id":
            userId = (long)obj;
            return true;
        case "token":
            token = (String)obj;
            return true;
        case "create_time":
            createTime = (java.util.Date)obj;
            return true;
        default :
            return false;
        }
    }

    @Override
    public String toString() {
        return "AccessToken[id:"+ id+",userId:"+ userId+",token:"+ (token == null ?"null":token.substring(0, Math.min(token.length(), 64)))+",createTime:"+ createTime+ "]";
    }

    @Override
    @JsonIgnore
    @Transient
    public AccessTokenMeta getEntityMeta() {
        return ENTITY_META;
    }


    public static final AccessTokenMeta ENTITY_META = AccessTokenMeta.instance;
}
