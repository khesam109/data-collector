package ir.rahyabcp.collector.dataaccess.remote.node.dto.rebrand;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class ExtendedPropertiesDeserializer extends JsonDeserializer<ExtendedPropertiesDto> {

    @Override
    public ExtendedPropertiesDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode node = mapper.readTree(p); // Read extende_properties as a tree

        // Retrieve the parent node containing dc_protocol
        ObjectNode parentNode = (ObjectNode) node.get("parent");

        // Find the dc_protocol value
        String dcProtocol = parentNode.get("dc_protocol").asText();

        // Choose sub-type based on dcProtocol
        if ("FTP".equalsIgnoreCase(dcProtocol)) {
            return mapper.treeToValue(node, FtpPropertiesDto.class);
        } else if ("RDB".equalsIgnoreCase(dcProtocol)) {
            return mapper.treeToValue(node, RdbPropertiesDto.class);
        } else {
            throw new RuntimeException("Unknown dc_protocol: " + dcProtocol);
        }
    }
}

