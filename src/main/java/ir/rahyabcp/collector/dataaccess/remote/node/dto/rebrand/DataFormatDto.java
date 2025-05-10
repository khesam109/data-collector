package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataFormatDto {

    @JsonProperty("fileformat_id")
    private int fileFormatId;
    @JsonProperty("fileformat_name")
    private String fileFormatName;
    @JsonProperty("fileformatitems")
    private List<FileFormatItem> fileFormatItems;

    public int getFileFormatId() {
        return fileFormatId;
    }

    public void setFileFormatId(int fileFormatId) {
        this.fileFormatId = fileFormatId;
    }

    public String getFileFormatName() {
        return fileFormatName;
    }

    public void setFileFormatName(String fileFormatName) {
        this.fileFormatName = fileFormatName;
    }

    public List<FileFormatItem> getFileFormatItems() {
        return fileFormatItems;
    }

    public void setFileFormatItems(List<FileFormatItem> fileFormatItems) {
        this.fileFormatItems = fileFormatItems;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FileFormatItem {

        @JsonProperty("fileformatitem_id")
        private int fileFormatItemId;
        @JsonProperty("fileformatitem_name")
        private String fileFormatItemName;

        public int getFileFormatItemId() {
            return fileFormatItemId;
        }

        public void setFileFormatItemId(int fileFormatItemId) {
            this.fileFormatItemId = fileFormatItemId;
        }

        public String getFileFormatItemName() {
            return fileFormatItemName;
        }

        public void setFileFormatItemName(String fileFormatItemName) {
            this.fileFormatItemName = fileFormatItemName;
        }
    }
}
