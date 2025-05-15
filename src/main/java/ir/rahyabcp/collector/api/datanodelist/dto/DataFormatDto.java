package ir.rahyabcp.collector.api.datanodelist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataFormatDto(

        @JsonProperty("fileformat_id")
        Integer fileFormatId,

        @JsonProperty("fileformat_name")
        String fileFormatName,

        @JsonProperty("record_delimiter")
        String recordDelimiter,

        @JsonProperty("field_delimiter")
        String fieldDelimiter,

        @JsonProperty("content_type")
        String contentType,

        @JsonProperty("fileformatitems_regex")
        String fileFormatItemsRegex,

        @JsonProperty("description")
        String description,

        @JsonProperty("fileformatitems")
        List<FileFormatItem> fileFormatItems
) {
}
