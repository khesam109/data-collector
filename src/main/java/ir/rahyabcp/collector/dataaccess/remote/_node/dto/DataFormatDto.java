package ir.rahyabcp.collector.dataaccess.remote._node.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataFormatDto(

        @JsonProperty("fileformat_id")
        Integer fileFormatId,

        @JsonProperty("fileformat_name")
        String fileFormatName,

        @JsonProperty("fileformatitems")
        List<FileFormatItem> fileFormatItems
) {
}
