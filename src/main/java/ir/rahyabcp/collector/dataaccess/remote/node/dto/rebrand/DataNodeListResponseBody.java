package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataNodeListResponseBody {

    @JsonProperty("data")
    private List<DataNodeDto> dataNodes;


    public List<DataNodeDto> getDataNodes() {
        return dataNodes;
    }

    public void setDataNodes(List<DataNodeDto> dataNodes) {
        this.dataNodes = dataNodes;
    }
}
