package ir.rahyabcp.collector.api.configlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ConfigListRequestBody(

        @JsonProperty("device_type")
        String deviceType,

        @JsonProperty("OS")
        String os,

        @JsonProperty("browser")
        String browser,

        @JsonProperty("channel_id")
        int channelId,

        @JsonProperty("channel_version")
        String channelVersion,

        @JsonProperty("device_id")
        String deviceId,

        @JsonProperty("system_id")
        int systemId,

        @JsonProperty("businesscenter_id")
        int businessCenterId,

        @JsonProperty("partner")
        PartnerDto partner,

        @JsonProperty("technologies")
        List<String> technologies,

        @JsonProperty("language_code")
        String languageCode
) {
}
