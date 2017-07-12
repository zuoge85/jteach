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

import org.forkjoin.jteach.open.db.entity.meta.SchemaVersionMeta;

public class SchemaVersionDO extends EntityObject<SchemaVersionDO, SchemaVersionDO.Key>{

    private int versionRank;
    private int installedRank;
    private String version;
    private String description;
    private String type;
    private String script;
    private Integer checksum;
    private String installedBy;
    private java.util.Date installedOn;
    private int executionTime;
    private boolean success;

    public static class Key implements KeyObject<SchemaVersionDO, SchemaVersionDO.Key>{
        private String version;

        public Key() {
        }

        public Key(String version) {
            this.version = version;
        }

        @JsonIgnore
        @Transient
        @Override
        public Object[] getQueryParams() {
            return new Object[]{
                getVersion()
            };
        }

        public String getVersion() {
            return version;
        }
        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public String toStringKey(){
            return String.valueOf(getVersion());

        }

        @Override
        public SchemaVersionMeta getEntityMeta() {
            return ENTITY_META;
        }

        @Override
        public String toString() {
            return "SchemaVersion[version:"+ (version == null ?"null":version.substring(0, Math.min(version.length(), 64)))+ "]";
        }
    }

    @Override
    public Key getKey() {
        return new Key() {

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                SchemaVersionDO.this.version  = version;
                SchemaVersionDO.this.changeProperty("version",version);
            }

            @Override
            public String toString() {
                return "SchemaVersion[version:"+ (version == null ?"null":version.substring(0, Math.min(version.length(), 64)))+ "]";
            }
        };
    }




    public SchemaVersionDO() {
    }

    public SchemaVersionDO(int versionRank,int installedRank,String version,String description,String type,String script,Integer checksum,String installedBy,java.util.Date installedOn,int executionTime,boolean success) {
        this.versionRank = versionRank;
        this.installedRank = installedRank;
        this.version = version;
        this.description = description;
        this.type = type;
        this.script = script;
        this.checksum = checksum;
        this.installedBy = installedBy;
        this.installedOn = installedOn;
        this.executionTime = executionTime;
        this.success = success;
    }


    public SchemaVersionDO newInstance(){
        return new SchemaVersionDO();
    }

    public void setKey(Object key){
        this.version = (String)key;
    }

    public int getVersionRank() {
        return versionRank;
    }

    public void setVersionRank(int versionRank) {
        this.versionRank = versionRank;
        changeProperty("versionRank",versionRank);
    }

    public int getInstalledRank() {
        return installedRank;
    }

    public void setInstalledRank(int installedRank) {
        this.installedRank = installedRank;
        changeProperty("installedRank",installedRank);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
        changeProperty("version",version);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        changeProperty("description",description);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        changeProperty("type",type);
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
        changeProperty("script",script);
    }

    public Integer getChecksum() {
        return checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
        changeProperty("checksum",checksum);
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
        changeProperty("installedBy",installedBy);
    }

    public java.util.Date getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(java.util.Date installedOn) {
        this.installedOn = installedOn;
        changeProperty("installedOn",installedOn);
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
        changeProperty("executionTime",executionTime);
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        changeProperty("success",success);
    }

    @Override
    public Object get(Field dbName){
        switch(dbName.getNativeValue()){
        case "version_rank":
            return versionRank;
        case "installed_rank":
            return installedRank;
        case "version":
            return version;
        case "description":
            return description;
        case "type":
            return type;
        case "script":
            return script;
        case "checksum":
            return checksum;
        case "installed_by":
            return installedBy;
        case "installed_on":
            return installedOn;
        case "execution_time":
            return executionTime;
        case "success":
            return success;
        default :
            return null;
        }
    }


    @Override
    public boolean set(Field dbName, Object obj) {
        switch(dbName.getNativeValue()){
        case "version_rank":
            versionRank = (int)obj;
            return true;
        case "installed_rank":
            installedRank = (int)obj;
            return true;
        case "version":
            version = (String)obj;
            return true;
        case "description":
            description = (String)obj;
            return true;
        case "type":
            type = (String)obj;
            return true;
        case "script":
            script = (String)obj;
            return true;
        case "checksum":
            checksum = (Integer)obj;
            return true;
        case "installed_by":
            installedBy = (String)obj;
            return true;
        case "installed_on":
            installedOn = (java.util.Date)obj;
            return true;
        case "execution_time":
            executionTime = (int)obj;
            return true;
        case "success":
            success = (boolean)obj;
            return true;
        default :
            return false;
        }
    }

    @Override
    public String toString() {
        return "SchemaVersion[versionRank:"+ versionRank+",installedRank:"+ installedRank+",version:"+ (version == null ?"null":version.substring(0, Math.min(version.length(), 64)))+",description:"+ (description == null ?"null":description.substring(0, Math.min(description.length(), 64)))+",type:"+ (type == null ?"null":type.substring(0, Math.min(type.length(), 64)))+",script:"+ (script == null ?"null":script.substring(0, Math.min(script.length(), 64)))+",checksum:"+ checksum+",installedBy:"+ (installedBy == null ?"null":installedBy.substring(0, Math.min(installedBy.length(), 64)))+",installedOn:"+ installedOn+",executionTime:"+ executionTime+",success:"+ success+ "]";
    }

    @Override
    @JsonIgnore
    @Transient
    public SchemaVersionMeta getEntityMeta() {
        return ENTITY_META;
    }


    public static final SchemaVersionMeta ENTITY_META = SchemaVersionMeta.instance;
}
