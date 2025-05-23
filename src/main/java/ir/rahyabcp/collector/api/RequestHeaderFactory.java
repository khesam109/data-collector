package ir.rahyabcp.collector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RequestHeaderFactory {

    private final DateTimeFormatter dateTimeFormatter;

    @Autowired
    public RequestHeaderFactory(
            DateTimeFormatter dateTimeFormatter
    ) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public RequestHeader configList() {
        return createRequestHeader(null, "sma.config_list");
    }

    public RequestHeader userLogin(String publicToken) {
        return createRequestHeader(publicToken, "sma.user_login");
    }

    public RequestHeader userLogout(String token) {
        return createRequestHeader(token, "sma.sma.user_logout");
    }

    public RequestHeader processList(String token) {
        return createRequestHeader(token, "coa.process_list");
    }

    public RequestHeader dataNodeList(String token) {
        return createRequestHeader(token, "dpa.datanode_list");
    }

    public RequestHeader streamList(String token) {
        return createRequestHeader(token, "dpa.stream_list");
    }

    private RequestHeader createRequestHeader(String token, String serviceName) {
        return new RequestHeader(token, serviceName, this.systemDate());
    }

    private String systemDate() {
        return LocalDateTime.now().format(this.dateTimeFormatter);
    }
}
