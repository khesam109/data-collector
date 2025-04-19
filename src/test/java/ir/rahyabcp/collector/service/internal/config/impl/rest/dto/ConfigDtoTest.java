package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.common.ConnectionProtocol;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ConfigDtoTest {

    private static final String SAMPLE_CONFIG_DTO = """
            {
              "collectors": [
                {
                  "host": "ftp.example.com",
                  "port": 21,
                  "protocol": "FTP"
                },
                {
                  "url": "api.example.com",
                  "protocol": "REST_API"
                }
              ]
            }
            """;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    void shouldDeserializeIntoConfigDto() throws IOException {
        ConfigDto configDto  = deserializeCollectorDto(SAMPLE_CONFIG_DTO);

        assertEquals(2, configDto.collectors().size());
        assertInstanceOf(FtpCollectorDto.class, configDto.collectors().getFirst());
        assertInstanceOf(RestCollectorDto.class, configDto.collectors().get(1));

        assertEquals(ConnectionProtocol.FTP, configDto.collectors().getFirst().getProtocol());
        assertEquals(ConnectionProtocol.REST_API, configDto.collectors().get(1).getProtocol());

        FtpCollectorDto ftpCollectorDto = (FtpCollectorDto) configDto.collectors().getFirst();

        assertEquals("ftp.example.com", ftpCollectorDto.getHost());
        assertEquals(21, ftpCollectorDto.getPort());

        RestCollectorDto restCollectorDto = (RestCollectorDto) configDto.collectors().get(1);

        assertEquals("api.example.com", restCollectorDto.getUrl());
    }

    private ConfigDto deserializeCollectorDto(String json) throws IOException {
        return OBJECT_MAPPER.readerFor(
                ConfigDto.class
        ).readValue(
                json
        );
    }
}
