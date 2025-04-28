package ir.rahyabcp.collector.service.internal.config.impl.rest.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.common.ConnectionProtocol;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Test class for verifying CollectorDto JSON deserialization behavior
 */
class CollectorDtoTest {

    private static final String SAMPLE_FTP_COLLECTOR_CONFIG_DTO = """
            {
              "host": "ftp.example.com",
              "port": 21,
              "username": "user",
              "password": "pass",
              "protocol": "FTP",
              "scheduling": {
                "interval": 10,
                "unit": "MINUTE"
              }
            }
            """;
    private static final String SAMPLE_REST_COLLECTOR_CONFIG_DTO = """
            {
              "url": "api.example.com",
              "protocol": "REST_API",
              "scheduling": {
                "interval": 11,
                "unit": "DAY"
              }
            }
            """;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @Test
    void shouldDeserializeIntoFtpCollectorDto() throws IOException {
        CollectorDto collectorDto  = deserializeCollectorDto(SAMPLE_FTP_COLLECTOR_CONFIG_DTO);

        assertInstanceOf(FtpCollectorDto.class, collectorDto);
        assertEquals(ConnectionProtocol.FTP, collectorDto.getProtocol());

        FtpCollectorDto ftpCollectorDto = (FtpCollectorDto) collectorDto;

        assertEquals("ftp.example.com", ftpCollectorDto.getHost());
        assertEquals(21, ftpCollectorDto.getPort());
        assertEquals("user", ftpCollectorDto.getUsername());
        assertEquals("pass", ftpCollectorDto.getPassword());

        assertEquals(10, ftpCollectorDto.getScheduling().interval());
        assertEquals(IntervalUnit.MINUTE, ftpCollectorDto.getScheduling().unit());
    }

    @Test
    void shouldDeserializeIntoRestCollectorDto() throws IOException {
        CollectorDto collectorDto = deserializeCollectorDto(SAMPLE_REST_COLLECTOR_CONFIG_DTO);

        assertInstanceOf(RestCollectorDto.class, collectorDto);
        assertEquals(ConnectionProtocol.REST_API, collectorDto.getProtocol());

        RestCollectorDto restCollectorDto = (RestCollectorDto) collectorDto;

        assertEquals("api.example.com", restCollectorDto.getUrl());

        assertEquals(11, restCollectorDto.getScheduling().interval());
        assertEquals(IntervalUnit.DAY, restCollectorDto.getScheduling().unit());
    }


    private CollectorDto deserializeCollectorDto(String json) throws IOException {
        return OBJECT_MAPPER.readerFor(
                CollectorDto.class
        ).readValue(
                json
        );
    }
}
