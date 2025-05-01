package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class DatabaseDataNodeDto extends DataNodeDto {

    @JsonCreator
    public DatabaseDataNodeDto() {
        super("DATABASE");
    }
}
