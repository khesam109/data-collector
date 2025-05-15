package ir.rahyabcp.collector.dataaccess.remote._node.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RdbPropertiesDto extends ExtendedPropertiesDto {

    @JsonProperty("rdb_connection_string")
    private String rdbConnectionString;

    @JsonProperty("rdb_db_type")
    private String rdbDbType;

    @JsonProperty("rdb_username")
    private String rdbUsername;

    @JsonProperty("rdb_password")
    private String rdbPassword;

    @JsonProperty("rdb_datasource")
    private String rdbDatasource;


    public String getRdbConnectionString() {
        return rdbConnectionString;
    }

    public void setRdbConnectionString(String rdbConnectionString) {
        this.rdbConnectionString = rdbConnectionString;
    }

    public String getRdbDbType() {
        return rdbDbType;
    }

    public void setRdbDbType(String rdbDbType) {
        this.rdbDbType = rdbDbType;
    }

    public String getRdbUsername() {
        return rdbUsername;
    }

    public void setRdbUsername(String rdbUsername) {
        this.rdbUsername = rdbUsername;
    }

    public String getRdbPassword() {
        return rdbPassword;
    }

    public void setRdbPassword(String rdbPassword) {
        this.rdbPassword = rdbPassword;
    }

    public String getRdbDatasource() {
        return rdbDatasource;
    }

    public void setRdbDatasource(String rdbDatasource) {
        this.rdbDatasource = rdbDatasource;
    }
}
