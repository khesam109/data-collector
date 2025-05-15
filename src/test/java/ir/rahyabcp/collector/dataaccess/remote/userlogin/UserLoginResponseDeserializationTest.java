package ir.rahyabcp.collector.dataaccess.remote.userlogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.dataaccess.remote.userlogin.dto.UserLoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserLoginResponseDeserializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void whenValidJson_thenDeserializeSuccessfully() throws Exception {
        UserLoginResponse result = objectMapper.readValue(sampleJsonResponse(), UserLoginResponse.class);

        assertNotNull(result);
        assertNotNull(result.getResponseHeader());
        assertNotNull(result.getResponseBody());

        assertEquals("0", result.getResponseHeader().messageCode());
        assertEquals("OK", result.getResponseHeader().messageText());
        assertEquals("20250507092041", result.getResponseHeader().sysDate());
        assertEquals("text/html; charset=UTF-8", result.getResponseHeader().encoding());

        assertEquals("01PRI----------------000000000001498000000000000020730000EXTERNALEN-----------------2025050709204100003600----------------999999999900000010060000000000013116000000000100027860----------------kqwqm0I2Ck9ypaU2xyL+KFiKclRKIEmpmR6ZCNSHsnoy1BhioFKVnQ==kqwqm0I0",
                result.getResponseBody().token());
        assertEquals("1001", result.getResponseBody().initPage());
        assertEquals("active", result.getResponseBody().businessStatus());
        assertEquals("Welcome to Telecommunication Infrastracture Company(TIC)", result.getResponseBody().businessMessage());
    }

    private String sampleJsonResponse() {
        return """
                {
                    "response_header": {
                        "message_code": "0",
                        "message_text": "OK",
                        "sysdate": "20250507092041",
                        "encoding": "text/html; charset=UTF-8"
                    },
                    "response_body": {
                        "token": "01PRI----------------000000000001498000000000000020730000EXTERNALEN-----------------2025050709204100003600----------------999999999900000010060000000000013116000000000100027860----------------kqwqm0I2Ck9ypaU2xyL+KFiKclRKIEmpmR6ZCNSHsnoy1BhioFKVnQ==kqwqm0I0",
                        "init_page": "1001",
                        "business_status": "active",
                        "business_message": "Welcome to Telecommunication Infrastracture Company(TIC)"
                    }
                }
        """;
    }
}
