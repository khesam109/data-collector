package ir.rahyabcp.collector.dataaccess.remote._node.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FileFormatItem(

        @JsonProperty("fileformatitem_id")
        Integer fileFormatItemId,

        @JsonProperty("fileformatitem_name")
        String fileFormatItemName
) {
}
