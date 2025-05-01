package ir.rahyabcp.collector.dataaccess.remote.node.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class RestDataNodeDto extends DataNodeDto {

    @JsonCreator
    public RestDataNodeDto() {
        super("REST_API");
    }
}
