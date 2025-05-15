package ir.rahyabcp.collector.dataaccess.remote;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RequestHeader(

        @JsonProperty("token") String token,
        @JsonProperty("service_name") String serviceName,
        @JsonProperty("sysdate") String sysDate
) {

}
