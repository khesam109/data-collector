package ir.rahyabcp.collector.api.configlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.api.configlist.dto.ConfigListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigListResponseDeserializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void whenValidJson_thenDeserializeSuccessfully() throws Exception {

        ConfigListResponse result = objectMapper.readValue(sampleJsonResponse(), ConfigListResponse.class);

        assertNotNull(result);
        assertNotNull(result.getResponseHeader());
        assertNotNull(result.getResponseBody());

        assertEquals("0", result.getResponseHeader().messageCode());
        assertEquals("OK", result.getResponseHeader().messageText());
        assertEquals("20250507091815", result.getResponseHeader().sysDate());
        assertEquals("text/html; charset=UTF-8", result.getResponseHeader().encoding());

        assertEquals("01PUB----------------000000000001497900000000000000030000EXTERNALEN-----------------2025050709181500003600----------------999999999900000010060000000000013115000000000100027859----------------BaRoBNL3+mfD9/rypy+8KCShsRR4+a6gPrIKd9UMkoZMoJvi099ZLA==BaRoBNL0",
                result.getResponseBody().publicToken());
        assertEquals("14979", result.getResponseBody().sessionId());
        assertEquals("13115", result.getResponseBody().deviceId());
        assertEquals("active", result.getResponseBody().businessStatus());
        assertEquals("Welcome to Telecommunication Infrastracture Company(TIC)", result.getResponseBody().businessMessage());

    }
    
    private String sampleJsonResponse() {
        return """
                {
                    "response_header": {
                        "message_code": "0",
                        "message_text": "OK",
                        "sysdate": "20250507091815",
                        "encoding": "text/html; charset=UTF-8"
                    },
                    "response_body": {
                        "public_token": "01PUB----------------000000000001497900000000000000030000EXTERNALEN-----------------2025050709181500003600----------------999999999900000010060000000000013115000000000100027859----------------BaRoBNL3+mfD9/rypy+8KCShsRR4+a6gPrIKd9UMkoZMoJvi099ZLA==BaRoBNL0",
                        "session_id": "14979",
                        "device_id": "13115",
                        "business_status": "active",
                        "business_message": "Welcome to Telecommunication Infrastracture Company(TIC)"
                    }
                }
        """;
    }
}
