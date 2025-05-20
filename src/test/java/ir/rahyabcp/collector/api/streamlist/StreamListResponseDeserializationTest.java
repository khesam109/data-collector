package ir.rahyabcp.collector.api.streamlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StreamListResponseDeserializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void whenValidJson_thenDeserializeSuccessfully() throws Exception {
        StreamListResponse result = objectMapper.readValue(sampleJsonResponse(), StreamListResponse.class);

        assertNotNull(result);
        assertNotNull(result.getResponseHeader());
        assertNotNull(result.getResponseBody());

        assertEquals("0", result.getResponseHeader().messageCode());
        assertEquals("OK", result.getResponseHeader().messageText());
        assertEquals("20250518123707", result.getResponseHeader().sysDate());
        assertEquals("text/html; charset=UTF-8", result.getResponseHeader().encoding());

        assertEquals(15, result.getResponseBody().data().size());

        assertEquals(264289, result.getResponseBody().data().getFirst().streamId());
        assertEquals("140402071400-7.VDR", result.getResponseBody().data().getFirst().streamName());
        assertEquals("CLOSED", result.getResponseBody().data().getFirst().streamStatus());
    }

    private String sampleJsonResponse() {
        return """
                {
                    "response_header": {
                        "message_code": "0",
                        "message_text": "OK",
                        "sysdate": "20250518123707",
                        "encoding": "text/html; charset=UTF-8"
                    },
                    "response_body": {
                        "data": [
                            {
                                "stream_id": 264289,
                                "stream_name": "140402071400-7.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264282,
                                "stream_name": "140402072000.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264295,
                                "stream_name": "140402071400-B.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264283,
                                "stream_name": "140402081200.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264285,
                                "stream_name": "140402081202.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264286,
                                "stream_name": "140402081204.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264287,
                                "stream_name": "140402081205.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264284,
                                "stream_name": "140402081201.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264281,
                                "stream_name": "140402072002.csv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264288,
                                "stream_name": "140402081206.tsv",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264290,
                                "stream_name": "140402071400-8.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264291,
                                "stream_name": "140402071400-9.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264292,
                                "stream_name": "140402071400-A.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264296,
                                "stream_name": "140402081900.VDR",
                                "stream_status": "CLOSED"
                            },
                            {
                                "stream_id": 264508,
                                "stream_name": "stream78test78787878.VDR",
                                "stream_status": "OPEN"
                            }
                        ]
                    }
                }
        """;
    }
}
