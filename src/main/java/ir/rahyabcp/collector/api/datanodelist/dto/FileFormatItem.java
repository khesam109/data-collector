package ir.rahyabcp.collector.api.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FileFormatItem(

        @JsonProperty("fileformatitem_id")
        Integer fileFormatItemId,

        @JsonProperty("fileformatitem_name")
        String fileFormatItemName,

        @JsonProperty("data_type")
        String dataType,

        @JsonProperty("data_format")
        String dataFormat,

        @JsonProperty("data_length")
        Integer dataLength,

        @JsonProperty("val_min")
        Integer valMin,

        @JsonProperty("val_max")
        Integer valMax,

        @JsonProperty("is_required")
        Boolean isRequired,

        @JsonProperty("order_no")
        Integer orderNo,

        @JsonProperty("internal_name")
        String internalName,

        @JsonProperty("description")
        String description
) {
}
