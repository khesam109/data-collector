package ir.rahyabcp.collector.dataaccess.remote.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FileFormatItem(

        @JsonProperty("fileformatitem_id")
        Integer fileFormatItemId,

        @JsonProperty("fileformatitem_name")
        String fileFormatItemName
) {
}
