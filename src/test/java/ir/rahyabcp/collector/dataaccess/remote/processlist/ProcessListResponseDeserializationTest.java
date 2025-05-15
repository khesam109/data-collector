package ir.rahyabcp.collector.dataaccess.remote.processlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.dataaccess.remote.processlist.dto.ProcessListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessListResponseDeserializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void whenValidJson_thenDeserializeSuccessfully() throws Exception {
        ProcessListResponse result = objectMapper.readValue(sampleJsonResponse(), ProcessListResponse.class);

        assertNotNull(result);
        assertNotNull(result.getResponseHeader());
        assertNotNull(result.getResponseBody());

        assertEquals("0", result.getResponseHeader().messageCode());
        assertEquals("OK", result.getResponseHeader().messageText());
        assertEquals("20250507174049", result.getResponseHeader().sysDate());
        assertEquals("text/html; charset=UTF-8", result.getResponseHeader().encoding());

        assertEquals(1, result.getResponseBody().data().size());
        assertEquals(1141, result.getResponseBody().data().getFirst().processId());
        assertEquals(1017, result.getResponseBody().data().getFirst().processType().id());
        assertEquals("Collector://Automated", result.getResponseBody().data().getFirst().processType().name());
        assertEquals("xxpclca.collector", result.getResponseBody().data().getFirst().executionUnit());
        assertEquals("STOPPED", result.getResponseBody().data().getFirst().processStatus());
        assertEquals("ASYNCHRONOUS", result.getResponseBody().data().getFirst().synchronousMode());
        assertEquals("ONCE", result.getResponseBody().data().getFirst().repeatInterval());
        assertNull(result.getResponseBody().data().getFirst().description());
    }

    private String sampleJsonResponse() {
        return """
                {
                    "response_header": {
                        "message_code": "0",
                        "message_text": "OK",
                        "sysdate": "20250507174049",
                        "encoding": "text/html; charset=UTF-8"
                    },
                    "response_body": {
                        "data": [
                            {
                                "process_id": 1141,
                                "processtype": {
                                    "processtype_id": 1017,
                                    "processtype_name": "Collector://Automated"
                                },
                                "execution_unit": "xxpclca.collector",
                                "process_status": "STOPPED",
                                "synchronous_mode": "ASYNCHRONOUS",
                                "repeat_interval": "ONCE",
                                "description": null
                            }
                        ]
                    }
                }
        """;
    }
}
