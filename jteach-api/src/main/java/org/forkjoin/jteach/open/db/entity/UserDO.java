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

import org.forkjoin.jteach.open.db.entity.meta.UserMeta;

public class UserDO extends EntityObject<UserDO, UserDO.Key>{

    /**用户id*/
    private int id;
    /**用户账号*/
    private String name;
    /**用户昵称*/
    private String nickName;
    /**手机号*/
    private String mobile;
    /**uuid*/
    private String uuid;
    /**用户密码HASH*/
    private String password;
    private java.util.Date createTime;
    private java.util.Date updateTime;

    public static class Key implements KeyObject<UserDO, UserDO.Key>{
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
        public UserMeta getEntityMeta() {
            return ENTITY_META;
        }

        @Override
        public String toString() {
            return "User[id:"+ id+ "]";
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
                return "User[id:"+ id+ "]";
            }
        };
    }




    public UserDO() {
    }

    public UserDO(String name,String nickName,String mobile,String uuid,String password,java.util.Date createTime,java.util.Date updateTime) {
        this.name = name;
        this.nickName = nickName;
        this.mobile = mobile;
        this.uuid = uuid;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public UserDO newInstance(){
        return new UserDO();
    }

    public void setKey(Object key){
        this.id = ((Number)key).intValue();
    }

    /**
     * 用户id
     **/
    public int getId() {
        return id;
    }

    /**
     * 用户id
     **/
    public void setId(int id) {
        this.id = id;
        changeProperty("id",id);
    }

    /**
     * 用户账号
     **/
    public String getName() {
        return name;
    }

    /**
     * 用户账号
     **/
    public void setName(String name) {
        this.name = name;
        changeProperty("name",name);
    }

    /**
     * 用户昵称
     **/
    public String getNickName() {
        return nickName;
    }

    /**
     * 用户昵称
     **/
    public void setNickName(String nickName) {
        this.nickName = nickName;
        changeProperty("nickName",nickName);
    }

    /**
     * 手机号
     **/
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     **/
    public void setMobile(String mobile) {
        this.mobile = mobile;
        changeProperty("mobile",mobile);
    }

    /**
     * uuid
     **/
    public String getUuid() {
        return uuid;
    }

    /**
     * uuid
     **/
    public void setUuid(String uuid) {
        this.uuid = uuid;
        changeProperty("uuid",uuid);
    }

    /**
     * 用户密码HASH
     **/
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码HASH
     **/
    public void setPassword(String password) {
        this.password = password;
        changeProperty("password",password);
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
        changeProperty("createTime",createTime);
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
        changeProperty("updateTime",updateTime);
    }

    @Override
    public Object get(Field dbName){
        switch(dbName.getNativeValue()){
        case "id":
            return id;
        case "name":
            return name;
        case "nickName":
            return nickName;
        case "mobile":
            return mobile;
        case "uuid":
            return uuid;
        case "password":
            return password;
        case "create_time":
            return createTime;
        case "update_time":
            return updateTime;
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
        case "name":
            name = (String)obj;
            return true;
        case "nickName":
            nickName = (String)obj;
            return true;
        case "mobile":
            mobile = (String)obj;
            return true;
        case "uuid":
            uuid = (String)obj;
            return true;
        case "password":
            password = (String)obj;
            return true;
        case "create_time":
            createTime = (java.util.Date)obj;
            return true;
        case "update_time":
            updateTime = (java.util.Date)obj;
            return true;
        default :
            return false;
        }
    }

    @Override
    public String toString() {
        return "User[id:"+ id+",name:"+ (name == null ?"null":name.substring(0, Math.min(name.length(), 64)))+",nickName:"+ (nickName == null ?"null":nickName.substring(0, Math.min(nickName.length(), 64)))+",mobile:"+ (mobile == null ?"null":mobile.substring(0, Math.min(mobile.length(), 64)))+",uuid:"+ (uuid == null ?"null":uuid.substring(0, Math.min(uuid.length(), 64)))+",password:"+ (password == null ?"null":password.substring(0, Math.min(password.length(), 64)))+",createTime:"+ createTime+",updateTime:"+ updateTime+ "]";
    }

    @Override
    @JsonIgnore
    @Transient
    public UserMeta getEntityMeta() {
        return ENTITY_META;
    }


    public static final UserMeta ENTITY_META = UserMeta.instance;
}
