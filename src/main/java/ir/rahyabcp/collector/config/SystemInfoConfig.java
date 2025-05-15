package ir.rahyabcp.collector.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.List;

@ConfigurationProperties(prefix = "system.info")
public class SystemInfoConfig {

    private final String deviceType;
    private final String os;
    private final String browser;
    private final int channelId;
    private final String channelVersion;
    private final String deviceId;
    private final int systemId;
    private final int businessCenterId;
    private final List<String> technologies;
    private final String languageCode;
    private final String partnerDomain;
    private final String partnerToken;

    @ConstructorBinding
    public SystemInfoConfig(
            String deviceType, String os, String browser, Integer channelId, String channelVersion, String deviceId,
            Integer systemId, Integer businessCenterId, List<String> technologies, String languageCode,
            String partnerDomain, String partnerToken
    ) {
        this.deviceType = deviceType;
        this.os = os;
        this.browser = browser;
        this.channelId = channelId;
        this.channelVersion = channelVersion;
        this.deviceId = deviceId;
        this.systemId = systemId;
        this.businessCenterId = businessCenterId;
        this.technologies = technologies;
        this.languageCode = languageCode;
        this.partnerDomain = partnerDomain;
        this.partnerToken = partnerToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }

    public int getChannelId() {
        return channelId;
    }

    public String getChannelVersion() {
        return channelVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public int getSystemId() {
        return systemId;
    }

    public int getBusinessCenterId() {
        return businessCenterId;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getPartnerDomain() {
        return partnerDomain;
    }

    public String getPartnerToken() {
        return partnerToken;
    }
}
